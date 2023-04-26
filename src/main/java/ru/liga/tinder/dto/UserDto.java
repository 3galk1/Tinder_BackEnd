package ru.liga.tinder.dto;

import lombok.*;
import ru.liga.tinder.model.type.GenderType;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserDto {

    private long id;
    private String userId;
    private GenderType gender;
    private String name;
    private String description;
    private GenderType searchGender;
    private String stageOfQuestionnaire;

}