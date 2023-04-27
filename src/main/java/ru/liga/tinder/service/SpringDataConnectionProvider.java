package ru.liga.tinder.service;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.liga.tinder.dto.UserDto;
import ru.liga.tinder.entity.User;
import ru.liga.tinder.mapper.UserMapper;
import ru.liga.tinder.repository.UserRepository;

import java.util.List;

@RequiredArgsConstructor
@Component
public class SpringDataConnectionProvider {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRepository userRepository;


    public List<UserDto> getAllUser() {
        return userMapper.createUserDtoList(userRepository.findAll());
    }

    public UserDto getUserById(long id) {
        return userMapper.createUserDto(userRepository.getUserById(id));
    }
    public UserDto getUserByUserId(String userId) {
        return userMapper.createUserDto(userRepository.getUserByUserId(userId));
    }

    public UserDto createUser(UserDto userDto) {
        User user = userMapper.createUser(userDto);
        User createUser = userRepository.save(user);
        return getUserById(createUser.getId());
    }


        public UserDto updateUser(UserDto userDto){
            User user = userRepository.getUserById(userDto.getId());
            user = userMapper.updateUser(userDto);
            userRepository.save(user);
            return getUserById(user.getId());
        }


}
