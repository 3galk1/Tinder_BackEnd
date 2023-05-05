package ru.liga.tinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.liga.tinder.entity.LikedUser;

import java.util.List;


public interface LikedUserRepository extends JpaRepository<LikedUser, Long> {

    List<LikedUser> getLikedUserByUserId(Long id);
}
