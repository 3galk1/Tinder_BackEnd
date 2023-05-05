package ru.liga.tinder.mapper;

import org.springframework.stereotype.Component;
import ru.liga.tinder.dto.LikedUserDto;
import ru.liga.tinder.entity.LikedUser;

import java.util.ArrayList;
import java.util.List;

@Component
public class LikedUserMapper {
    public List<LikedUserDto> createLikedUserDtoList(List<LikedUser> likedUser) {
        List<LikedUserDto> likedUserDto = new ArrayList<>();
        for (LikedUser likedUs : likedUser) {
            likedUserDto.add(createLikedUserDto(likedUs));
        }
        return likedUserDto;
    }

    public LikedUserDto createLikedUserDto(LikedUser likedUser) {
        return LikedUserDto.builder()
                .likedUserId(likedUser.getLikedUserId())
                .build();
    }
}
