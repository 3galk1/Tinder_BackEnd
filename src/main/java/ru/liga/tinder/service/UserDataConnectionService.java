package ru.liga.tinder.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.liga.tinder.dto.UserDto;
import ru.liga.tinder.entity.User;
import ru.liga.tinder.exception.SQLException;
import ru.liga.tinder.mapper.UserMapper;
import ru.liga.tinder.repository.UserRepository;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Component
public class UserDataConnectionService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public UserDto getUserByTelegramId(String telegramId) {
        return userMapper.createUserDto(userRepository.getUserByTelegramId(telegramId));
    }

    public UserDto updateUser(String telegramId, UserDto userDto) {
        log.info("Обновление данных пользователя");
        User user = userRepository.getUserByTelegramId(telegramId);
        user = userMapper.updateUser(userDto, user);
        userRepository.save(user);
        return userMapper.createUserDto(
                userRepository.getUserByTelegramId(telegramId));
    }

    public UserDto createUser(UserDto userDto) {
        log.info("Создание нового пользователя");
        User user = userMapper.createUser(userDto);
        userRepository.save(user);
        try {
            userRepository.save(user);
        } catch (SQLException e) {
            log.error("Ошибка при создании пользователя. Такой пользователь уже существует " + e.getMessage());
            user.setErrorMessage("Ошибка при создании пользователя. Такой пользователь уже существует");
            return userMapper.createUserDtoErrorMessage(
                    userRepository.getUserByTelegramId(user.getTelegramId()));
        }
        return userMapper.createUserDto(
                userRepository.getUserByTelegramId(user.getTelegramId()));
    }

    public List<UserDto> getAllUser() {
        return userMapper.createUserDtoList(userRepository.findAll());
    }

    public UserDto getPreferenceUser(String telegramId, String direction) {
        User currentUser = userRepository.getUserByTelegramId(telegramId);
        List<User> allPreferenceUsers = userRepository.findAllPreferenceUsers(currentUser);
        if (direction.equals("forward")) {
            return userMapper.createUserDto(getNextUser(allPreferenceUsers, currentUser));
        }
        return userMapper.createUserDto(getPreviousUser(allPreferenceUsers, currentUser));
    }

    private User getNextUser(List<User> allPreferenceUsers, User currentUser) {
        for (int i = 0; i < allPreferenceUsers.size() - 1; i++) {
            if (currentUser.getCurrentViewedUserId() == allPreferenceUsers.get(i).getId() &&
                    i < allPreferenceUsers.size() - 1) {
                currentUser.setCurrentViewedUserId(allPreferenceUsers.get(i + 1).getId());
                userRepository.save(currentUser);
                return allPreferenceUsers.get(i + 1);
            }
        }
        currentUser.setCurrentViewedUserId(allPreferenceUsers.get(0).getId());
        userRepository.save(currentUser);
        return allPreferenceUsers.get(0);
    }

    private User getPreviousUser(List<User> allPreferenceUsers, User currentUser) {
        for (int i = allPreferenceUsers.size() - 1; i >= 0; i--) {
            if (currentUser.getCurrentViewedUserId() == allPreferenceUsers.get(i).getId() && i > 0) {
                currentUser.setCurrentViewedUserId(allPreferenceUsers.get(i - 1).getId());
                return allPreferenceUsers.get(i - 1);
            }
        }
        currentUser.setCurrentViewedUserId(allPreferenceUsers.get(0).getId());
        userRepository.save(currentUser);
        return allPreferenceUsers.get(0);
    }
}
