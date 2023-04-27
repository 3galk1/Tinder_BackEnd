package ru.liga.tinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.liga.tinder.entity.User;

import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAll();

    User getUserById(long id);

    User getUserByUserId(String userId);
}
