package ru.liga.tinder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.liga.tinder.dto.User;
import ru.liga.tinder.service.SpringJdbcConnectionProvider;

import java.util.List;

@Component
public class JdbcConnectionController {

    @Autowired
    private SpringJdbcConnectionProvider springJdbcConnectionProvider;

    public List<User> getAllUser() {
        return springJdbcConnectionProvider.getAllUser();
    }

    public User getUserById(int id) {
        List<User> user = getAllUser();
        for (User customer : user) {
            if (customer.getId() == id) {
                return customer;

            }
        }
        return null;
    }


}
