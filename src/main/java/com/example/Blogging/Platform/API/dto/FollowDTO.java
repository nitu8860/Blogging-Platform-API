package com.example.Blogging.Platform.API.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FollowDTO {
    @NotNull(message = "enter user id")
    private Long followerId;
    @NotNull(message = "enter user id")
    private Long followingId;
}