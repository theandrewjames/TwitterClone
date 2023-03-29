package com.cooksys.socialmedia.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class HashtagDto {

	private String label;

	private Timestamp firstUsed;

	private Timestamp lastUsed;
}
