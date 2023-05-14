package ru.liga.tinder.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.liga.tinder.dto.UserDto;
import ru.liga.tinder.entity.User;
import ru.liga.tinder.exception.SQLException;
import ru.liga.tinder.mapper.UserMapper;
import ru.liga.tinder.repository.UserRepository;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserDataConnectionService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public UserDto findUser(String telegramId) {
        log.info("Поиск клиента");
        return userMapper.toDto(userRepository.getUserByTelegramId(telegramId));
    }

    public UserDto updateUser(String telegramId, UserDto userDto) {
        log.info("Обновление данных пользователя");
        User user = userRepository.getUserByTelegramId(telegramId);
        user = userMapper.toEntityUpdate(userDto, user);
        return userMapper.toDto(userRepository.save(user));
    }

    public UserDto createUser(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        try {
            log.info("Создание нового пользователя");
            userRepository.save(user);
        } catch (SQLException e) {
            log.error("Ошибка при создании пользователя. Такой пользователь уже существует " + e.getMessage());
            user.setErrorMessage("Ошибка при создании пользователя. Такой пользователь уже существует");
            return userMapper.toDtoErrorMessage(user);
        }
        return userMapper.toDto(user);
    }

    public List<UserDto> findAllUser() {
        return userMapper.toDtoList(userRepository.findAll());
    }

    public UserDto findPreferenceUser(String telegramId, String direction) {
        User currentUser = userRepository.getUserByTelegramId(telegramId);
        List<User> allPreferenceUsers = userRepository.findAllPreferenceUsers(currentUser);
        if (direction.equals("next")) {
            log.info("Поиск следующего пользователя");
            return userMapper.toDto(findNextUser(allPreferenceUsers, currentUser));
        }
        log.info("Поиск предыдушего пользователя");
        return userMapper.toDto(findPreviousUser(allPreferenceUsers, currentUser));
    }

    private User findNextUser(List<User> allPreferenceUsers, User currentUser) {
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

    private User findPreviousUser(List<User> allPreferenceUsers, User currentUser) {
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
