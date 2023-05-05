package ru.liga.tinder.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.liga.tinder.dto.LikedUserDto;
import ru.liga.tinder.entity.User;
import ru.liga.tinder.mapper.LikedUserMapper;
import ru.liga.tinder.repository.LikedUserRepository;
import ru.liga.tinder.repository.UserRepository;

import java.util.List;

@RequiredArgsConstructor
@Component
public class LikedUserDataConnectionService {

    private final LikedUserMapper likedUserMapper;
    private final LikedUserRepository likedUserRepository;
    private final UserRepository userRepository;


    public List<LikedUserDto> getLikedUsersByUserId(String telegramId) {
        User user = userRepository.getUserByTelegramId(telegramId);
        return likedUserMapper.createLikedUserDtoList(
                likedUserRepository.getLikedUserByUserId(user.getId()));
    }


//
//    public LikedUser addLikedUser(UserDto userDto) {
//        User user = userMapper.createUser(userDto);
//        userRepository.save(user);
//        return null;
//    }


}
