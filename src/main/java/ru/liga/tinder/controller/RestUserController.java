package ru.liga.tinder.controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.liga.tinder.dto.UserDto;
import ru.liga.tinder.entity.User;
import ru.liga.tinder.service.SpringDataConnectionProvider;

import java.util.List;

@Data
@RestController
@RequestMapping("/api/tinder-server/users")
public class RestUserController {

    @Autowired
    private SpringDataConnectionProvider springDataConnectionProvider;

    @GetMapping()
    public List<UserDto> getAllUsers() {
        return springDataConnectionProvider.getAllUser();
    }

    @GetMapping("/{id}")
    public UserDto getById(@PathVariable("id") long id) {
        return springDataConnectionProvider.getUserById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto createUser(@RequestBody UserDto user) {
        springDataConnectionProvider.createUser(user);
        return springDataConnectionProvider.createUser(user);
    }

//    @PatchMapping()
//    @ResponseStatus(HttpStatus.OK)
//    public HttpStatus updateUser (@RequestBody UserDto user){
//        springDataConnectionProvider.updateUser(user);
//        return HttpStatus.OK;
//    }

}
