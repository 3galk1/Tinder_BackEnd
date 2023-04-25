package ru.liga.tinder.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "customer", schema = "server")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column (name = "user_id")
    private String userId;
    @Column (name = "fio")
    private String FIO;
    @Column(name = "gender_type")
    private String genderType;
    @Column (name = "description")
    private String decsription;
    @Column (name = "search_gender")
    private String searchGender;
    @Column (name = "state")
    private String state;
}
