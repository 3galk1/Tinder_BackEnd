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
    @JsonProperty("genderType")
    private String genderType;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("searchGender")
    private String searchGender;
    @JsonProperty("stageOfQuestionnaire")
    private String stageOfQuestionnaire;

}
 