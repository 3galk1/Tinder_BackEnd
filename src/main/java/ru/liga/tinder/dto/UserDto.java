package ru.liga.tinder.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserDto {

    private long id;
    @JsonProperty("telegram_id")
    private String telegramId;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("preference")
    private String preference;
    @JsonProperty("stage_of_questionnaire")
    private int stageOfQuestionnaire;
    @JsonProperty("current_viewed_user_id")
    private long currentViewedUserId;
    @JsonProperty("error_message")
    private String errorMessage;

}
 