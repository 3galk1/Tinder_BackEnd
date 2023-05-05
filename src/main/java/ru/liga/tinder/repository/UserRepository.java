package ru.liga.tinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.liga.tinder.entity.User;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAll();

    User getUserByTelegramId(String telegramId);
}
