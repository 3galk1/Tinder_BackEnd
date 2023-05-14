package ru.liga.tinder.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class LikedUserDto {
    private long id;
    @JsonProperty("user_id")
    private long userId;
    @JsonProperty("liked_user_id")
    private long likedUserId;
}
