package ru.liga.tinder.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user", schema = "tinder")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "telegram_id")
    private String userId;
    @Column(name = "name")
    private String name;
    @Column(name = "gender_type")
    private String genderType;
    @Column(name = "search_gender")
    private String searchGender;
    @Column(name = "description")
    private String decsription;
    @Column(name = "stage_of_questionnaire")
    private String stateOfQuestionnaire;


//    @OneToMany
//    @JoinColumn(name = "id")
//    private List<User> likedUser;
}
