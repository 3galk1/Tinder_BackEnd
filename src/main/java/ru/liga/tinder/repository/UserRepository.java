package ru.liga.tinder.repository;

import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.liga.tinder.entity.User;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAll();

    User getUserByTelegramId(String telegramId);

    @Query(value = "SELECT * FROM TINDER.USER " +
            "WHERE ID <> :#{#user.id} AND (PREFERENCE = :#{#user.preference} OR PREFERENCE = 'ALL')" +
            "ORDER BY ID ASC", nativeQuery = true)
    List<User> findAllPreferenceUsers(User user);

    @Query(value = "SELECT * FROM TINDER.USER " +
            "WHERE ID <> :#{#user.id} AND (PREFERENCE = :#{#user.preference} OR PREFERENCE = 'ALL') AND ID > :#{#user.currentViewedUserId} " +
            "ORDER BY ID ASC LIMIT 1", nativeQuery = true)
    User findNextPreferenceUser(User user);

    @Query(value = "SELECT * FROM TINDER.USER " +
            "WHERE ID <> :#{#user.id} AND (PREFERENCE = :#{#user.preference} OR PREFERENCE = 'ALL') AND ID < :#{#user.currentViewedUserId} " +
            "ORDER BY ID ASC LIMIT 1", nativeQuery = true)
    User findPreviousPreferenceUser(User user);
}
