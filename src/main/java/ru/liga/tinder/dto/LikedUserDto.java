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
    @JsonProperty("userId")
    private String userId;
    @JsonProperty("likedUserId")
    private String likedUserId;
}
