package ru.liga.tinder.controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.liga.tinder.entity.User;
import ru.liga.tinder.service.SpringDataConnectionProvider;

import java.util.List;

@Data
@RestController
@RequestMapping("/api/tinder-server/user")
public class RestUserController {

    @Autowired
    private SpringDataConnectionProvider springDataConnectionProvider;

    @GetMapping()
    public List<User> getAllUser() {
        return springDataConnectionProvider.getAllUser();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable("id") long id) {
        return springDataConnectionProvider.getUserById(id);
    }
//    @GetMapping("/{id}/state")
//    public User getStateById(@RequestParam("id") long id) {
//        return springDataConnectionProvider.getStateById(id);
//    }


//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public User create(@RequestBody User user) {
//        return new User(
//                user.getId(),
//                user.getName(),
//                user.getDate(),
//                user.getStatus()
//        );
//    }

}
