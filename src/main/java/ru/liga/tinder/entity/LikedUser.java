package ru.liga.tinder.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "liked_user", schema = "server")
public class LikedUser {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column (name = "user_id")
    private String userId;
    @Column (name = "liked_user_Id")
    private String likedUserId;


}
