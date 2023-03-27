package com.cooksys.socialmedia.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class HashtagRequestDto {
    private Long id;
    private String label;
}
