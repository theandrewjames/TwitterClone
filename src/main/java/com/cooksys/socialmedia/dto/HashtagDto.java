package com.cooksys.socialmedia.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HashtagDto {

	private String label;

	private Timestamp firstUsed;

	private Timestamp lastUsed;
}
