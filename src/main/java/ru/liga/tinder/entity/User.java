package ru.liga.tinder.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
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
    @Column(name = "created")
    private LocalDate created;
    @Column(name = "telegram_id")
    private String telegramId;
    @Column(name = "name")
    private String name;
    @Column(name = "gender")
    private String gender;
    @Column(name = "preference")
    private String preference;
    @Column(name = "description")
    private String description;
    @Column(name = "stage_of_questionnaire")
    private int stageOfQuestionnaire;
    @Column(name = "current_viewed_user_id")
    private long currentViewedUserId;
    @Column(name = "error_message")
    private String errorMessage;
}
