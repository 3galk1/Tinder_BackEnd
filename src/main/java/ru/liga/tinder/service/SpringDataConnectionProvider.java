package ru.liga.tinder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.liga.tinder.entity.User;
import ru.liga.tinder.repository.UserRepository;

import java.util.List;

@Component
public class SpringDataConnectionProvider {
        @Autowired
        private UserRepository userRepository;

        public List<User> getAllUser () {
            return userRepository.findAll();
        }

        public User getUserById(long id) {
            return userRepository.getUserById(id);
        }

//        public User getStateById(long id) {
//            return userRepository.getStateById(id);
//        }

}
