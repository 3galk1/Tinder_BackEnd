package ru.liga.tinder.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.postgresql.util.PSQLException;
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
        //todo добавить валидацию, если такой пользователь есть в БД
        log.info("Создание нового пользователя");
        User user = userMapper.createUser(userDto);
        userRepository.save(user);
//        try {
//            userRepository.save(user);
//        } catch (PSQLException ex) {
//                log.error("Ошибка создания пользователя " + ex);
//                throw new SQLException("Ошибка создания пользователя " + ex);
//        }
        return userMapper.createUserDto(
                userRepository.getUserByTelegramId(user.getTelegramId()));
    }

    public List<UserDto> getAllUser() {
        return userMapper.createUserDtoList(userRepository.findAll());
    }
}
