package ru.liga.tinder.entity;

import jakarta.persistence.*;
import lombok.*;
import ru.liga.tinder.model.type.GenderType;

import java.io.Serializable;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user", schema = "server")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "fio")
    private String FIO;
    @Column(name = "gender_type")
    private String genderType;
    @Column(name = "description")
    private String decsription;
    @Column(name = "search_gender")
    private String searchGender;
    @Column(name = "stage_of_questionnaire")
    private String stateOfQuestionnaire;
}
