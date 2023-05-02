package ru.liga.tinder.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "liked_user", schema = "tinder")
public class LikedUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column (name = "user_id") //join from user
    private String userId;
    @Column (name = "liked_user_Id")
    private String likedUserId;


}
