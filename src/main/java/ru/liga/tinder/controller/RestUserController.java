package ru.liga.tinder.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.liga.tinder.dto.UserDto;
import ru.liga.tinder.entity.LikedUser;
import ru.liga.tinder.entity.User;
import ru.liga.tinder.service.SpringDataConnectionProvider;

import java.util.List;

@Data
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/tinder-server/user")
public class RestUserController {

    private final SpringDataConnectionProvider springDataConnectionProvider;

    @GetMapping()
    public List<UserDto> getAllUsers() {
        return springDataConnectionProvider.getAllUser();
    }

    @GetMapping("/{id}")
    public UserDto getById(@PathVariable("id") long id) {
        return springDataConnectionProvider.getUserById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto createUser(@RequestBody UserDto user) {
        return springDataConnectionProvider.createUser(user);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDto updateUser(@PathVariable("id") long id, @RequestBody UserDto userDto) {
        return springDataConnectionProvider.updateUser(id, userDto);
    }

    @GetMapping("/likedUser/id}")
    @ResponseStatus(HttpStatus.OK)
    public List<LikedUser> getlLikedUserById(@PathVariable("id") long userId) {
        return springDataConnectionProvider.getUserById(userId);
    }

}
