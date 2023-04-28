package ru.liga.tinder.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import ru.liga.tinder.model.type.GenderType;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserDto {

    private long id;
    @JsonProperty("userId")
    private String userId;
    private String genderType;
    private String name;
    private String description;
    private String searchGender;
    private String stageOfQuestionnaire;

}
 