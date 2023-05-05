package ru.liga.tinder.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.liga.tinder.dto.LikedUserDto;
import ru.liga.tinder.dto.UserDto;
import ru.liga.tinder.entity.User;
import ru.liga.tinder.service.LikedUserDataConnectionService;
import ru.liga.tinder.service.UserDataConnectionService;

import java.util.List;

@Data
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/tinder-server/user")
public class RestUserController {
    private final LikedUserDataConnectionService likedUserDataConnectionService;
    private final UserDataConnectionService userDataConnectionService;

    @GetMapping()
    public List<UserDto> getAllUsers() {
        return userDataConnectionService.getAllUser();
    }

    @GetMapping("/{telegramId}")
    public UserDto getById(@PathVariable("telegramId") String telegramId) {
        return userDataConnectionService.getUserByTelegramId(telegramId);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto createUser(@RequestBody UserDto user) {
        return userDataConnectionService.createUser(user);
    }

    @PatchMapping("/{telegramId}")
    @ResponseStatus(HttpStatus.OK)
    public UserDto updateUser(@PathVariable("telegramId") String telegramId, @RequestBody UserDto userDto) {
        return userDataConnectionService.updateUser(telegramId, userDto);
    }

    @GetMapping("/next/{telegramId}")
    @ResponseStatus(HttpStatus.OK)
    public UserDto getNextUser(@PathVariable("telegramId") String telegramId) {
        return userDataConnectionService.getPreferenceUser(telegramId, "forward");
    }

    @GetMapping("/previous/{telegramId}")
    @ResponseStatus(HttpStatus.OK)
    public UserDto getPreviousUser(@PathVariable("telegramId") String telegramId) {
        return userDataConnectionService.getPreferenceUser(telegramId, "reverse");}

    //todo пользователи которые лайкнули (в процессе)
    @GetMapping("/likedUser/{telegramId}")
    @ResponseStatus(HttpStatus.OK)
    public List<LikedUserDto> getlLikedUserById(@PathVariable("telegramId") String telegramId) {
        return likedUserDataConnectionService.getLikedUsersByUserId(telegramId);
    }

    //todo пользователь которого лайкнули (в процессе)
    @PostMapping(value = "/like/{telegramId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<LikedUserDto> addLikeUser(@PathVariable("telegramId") String telegramId) {
        return likedUserDataConnectionService.getLikedUsersByUserId(telegramId);
    }


}
