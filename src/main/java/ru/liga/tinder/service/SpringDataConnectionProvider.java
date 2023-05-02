package ru.liga.tinder.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.liga.tinder.dto.UserDto;
import ru.liga.tinder.entity.User;
import ru.liga.tinder.mapper.UserMapper;
import ru.liga.tinder.repository.LikedUserRepository;
import ru.liga.tinder.repository.UserRepository;

import java.util.List;

@RequiredArgsConstructor
@Component
public class SpringDataConnectionProvider {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LikedUserRepository likedUserRepository;


    public List<UserDto> getAllUser() {
        return userMapper.createUserDtoList(userRepository.findAll());
    }

    public UserDto getUserById(long id) {
        return userMapper.createUserDto(userRepository.getUserById(id));
    }


    public UserDto updateUser (long id, UserDto userDto) {
        User user = userRepository.getUserById(id);
        user = userMapper.updateUser(userDto, user);
        userRepository.save(user);
        return userMapper.createUserDto(
                userRepository.getUserById(id));
    }


    //    public UserDto getUserByUserId(String userId) {
//        return userMapper.createUserDto(userRepository.getUserByUserId(userId));
//    }
    public UserDto createUser(UserDto userDto) {
        User user = userMapper.createUser(userDto);
        userRepository.save(user);
        return null;
    }

}
