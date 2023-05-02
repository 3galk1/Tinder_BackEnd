package ru.liga.tinder.mapper;

import org.springframework.stereotype.Component;
import ru.liga.tinder.dto.UserDto;
import ru.liga.tinder.entity.User;

import java.util.ArrayList;
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
                .userId(user.getUserId())
                .name(user.getName())
                .genderType(user.getGenderType())
                .description(user.getDecsription())
                .searchGender(user.getSearchGender())
                .stageOfQuestionnaire(user.getStateOfQuestionnaire())
                .build();
    }

    public User createUser(UserDto userDto) {
        return User.builder()
                .id(userDto.getId())
                .userId(userDto.getUserId())
                .name(userDto.getName())
                .genderType(userDto.getGenderType())
                .decsription(userDto.getDescription())
                .searchGender(userDto.getSearchGender())
                .stateOfQuestionnaire(userDto.getStageOfQuestionnaire())
                .build();
    }

    public User updateUser(UserDto userDto, User user) {
        if (!userDto.getGenderType().isEmpty()) {
            user.setGenderType(userDto.getGenderType());
        } else if (!userDto.getName().isEmpty()) {
            user.setName(userDto.getName());
        } else if (!userDto.getDescription().isEmpty()) {
            user.setDecsription(userDto.getDescription());
        } else if (!userDto.getSearchGender().isEmpty()) {
            user.setSearchGender(userDto.getSearchGender());
        } else if (!userDto.getStageOfQuestionnaire().isEmpty()) {
            user.setStateOfQuestionnaire(userDto.getStageOfQuestionnaire());
        }
        return user;
    }
}
