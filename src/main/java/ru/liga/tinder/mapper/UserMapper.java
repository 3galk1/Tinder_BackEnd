package ru.liga.tinder.mapper;

import org.springframework.stereotype.Component;
import ru.liga.tinder.dto.UserDto;
import ru.liga.tinder.entity.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserMapper {

    public List<UserDto> createUserDtoList(List<User> user) {
        List<UserDto> userDto = new ArrayList<>();
        for (User us : user) {
            userDto.add(createUserDto(us));
        }
        return userDto;
    }

    public UserDto createUserDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .telegramId(user.getTelegramId())
                .name(user.getName())
                .gender(user.getGender())
                .description(user.getDecsription())
                .preference(user.getPreference())
                .stageOfQuestionnaire(user.getStateOfQuestionnaire())
                .build();
    }
    public UserDto createUserDtoErrorMessage(User user) {
        return UserDto.builder()
                .id(user.getId())
                .telegramId(user.getTelegramId())
                .errorMessage(user.getErrorMessage())
                .build();
    }

    public User createUser(UserDto userDto) {
        return User.builder()
                .id(userDto.getId())
                .created(new Date())
                .telegramId(userDto.getTelegramId())
                .name(userDto.getName())
                .gender(userDto.getGender())
                .decsription(userDto.getDescription())
                .preference(userDto.getPreference())
                .stateOfQuestionnaire(userDto.getStageOfQuestionnaire())
                .errorMessage("")
                .build();
    }

    public User updateUser(UserDto userDto, User user) {
        if (!userDto.getGender().isEmpty()) {
            user.setGender(userDto.getGender());
        } else if (!userDto.getName().isEmpty()) {
            user.setName(userDto.getName());
        } else if (!userDto.getDescription().isEmpty()) {
            user.setDecsription(userDto.getDescription());
        } else if (!userDto.getPreference().isEmpty()) {
            user.setPreference(userDto.getPreference());
        } else if (userDto.getStageOfQuestionnaire()!=1) {
            user.setStateOfQuestionnaire(userDto.getStageOfQuestionnaire());
        }
            user.setCreated(new Date());
        return user;
    }
}
