package ru.liga.tinder.mapper;

import org.springframework.stereotype.Component;
import ru.liga.tinder.dto.UserDto;
import ru.liga.tinder.entity.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {

    public List<UserDto> toDtoList(List<User> user) {
        List<UserDto> userDto = new ArrayList<>();
        for (User us : user) {
            userDto.add(toDto(us));
        }
        return userDto;
    }

    public UserDto toDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .telegramId(user.getTelegramId())
                .name(user.getName())
                .gender(user.getGender())
                .description(user.getDescription())
                .preference(user.getPreference())
                .stageOfQuestionnaire(user.getStageOfQuestionnaire())
                .build();
    }
    public UserDto toDtoErrorMessage(User user) {
        return UserDto.builder()
                .id(user.getId())
                .telegramId(user.getTelegramId())
                .errorMessage(user.getErrorMessage())
                .build();
    }

    public User toEntity(UserDto userDto) {
        return User.builder()
                .id(userDto.getId())
                .telegramId(userDto.getTelegramId())
                .created(LocalDate.now())
                .name(userDto.getName())
                .gender(userDto.getGender())
                .description(userDto.getDescription())
                .preference(userDto.getPreference())
                .stageOfQuestionnaire(userDto.getStageOfQuestionnaire())
                .errorMessage("")
                .build();
    }

    public User toEntityUpdate(UserDto userDto, User user) {
        if (!userDto.getGender().isEmpty()) {
            user.setGender(userDto.getGender());
        } else if (!userDto.getName().isEmpty()) {
            user.setName(userDto.getName());
        } else if (!userDto.getDescription().isEmpty()) {
            user.setDescription(userDto.getDescription());
        } else if (!userDto.getPreference().isEmpty()) {
            user.setPreference(userDto.getPreference());
        } else if (userDto.getStageOfQuestionnaire()!=1) {
            user.setStageOfQuestionnaire(userDto.getStageOfQuestionnaire());
        }
        return user;
    }
}
