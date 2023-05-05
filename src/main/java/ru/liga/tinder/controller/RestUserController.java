package ru.liga.tinder.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.liga.tinder.dto.LikedUserDto;
import ru.liga.tinder.dto.UserDto;
import ru.liga.tinder.service.LikedUserDataConnectionService;
import ru.liga.tinder.service.UserDataConnectionService;

import java.util.List;

@Data
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/tinder-server/user")
public class RestUserController {
    private final LikedUserDataConnectionService likedUserDataConnectionService;
    private final UserDataConnectionService userDataConnection;

    @GetMapping()
    public List<UserDto> getAllUsers() {
        return userDataConnection.getAllUser();
    }

    @GetMapping("/{telegramId}")
    public UserDto getById(@PathVariable("telegramId") String telegramId) {
        return userDataConnection.getUserByTelegramId(telegramId);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto createUser(@RequestBody UserDto user) {
        return userDataConnection.createUser(user);
    }

    @PatchMapping("/{telegramId}")
    @ResponseStatus(HttpStatus.OK)
    public UserDto updateUser(@PathVariable("telegramId") String telegramId, @RequestBody UserDto userDto) {
        return userDataConnection.updateUser(telegramId, userDto);
    }

    @GetMapping("/likedUser/{telegramId}")
    @ResponseStatus(HttpStatus.OK)
    public List<LikedUserDto> getlLikedUserById(@PathVariable("telegramId") String telegramId) {
        return likedUserDataConnectionService.getLikedUsersByUserId(telegramId);
    }

}
