package ru.liga.tinder.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class User {

    private long id;
    private String userId;
    private String gender;
    private String name;
    private String description;
    private String searchGender;
}
