package ru.liga.tinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.liga.tinder.entity.LikedUser;
import ru.liga.tinder.entity.User;

@Repository
public interface LikedUserRepository extends JpaRepository<LikedUser, Long> {
    LikedUser getUserByUserId(long id);
}
