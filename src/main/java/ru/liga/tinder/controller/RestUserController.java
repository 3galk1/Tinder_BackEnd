package ru.liga.tinder.controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.liga.tinder.dto.User;

import java.util.List;
@Data
@RestController
@RequestMapping("/api/tinder-server/user")
public class RestUserController {

    @Autowired
    private JdbcConnectionController jdbcConnectionController;

    @GetMapping()
    public List<User> getAllUser() {
        return jdbcConnectionController.getAllUser();
    }
    @GetMapping("/{id}")
    public User getById(@PathVariable("id") int id) {
        return jdbcConnectionController.getUserById(id);
    }
}
