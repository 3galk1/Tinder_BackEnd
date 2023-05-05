package ru.liga.tinder.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class LikedUserDto {

    @JsonProperty("userId")
    private int userId;
    @JsonProperty("likedUserId")
    private int likedUserId;
}
