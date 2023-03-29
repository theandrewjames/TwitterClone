package com.cooksys.socialmedia.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProfileDto {
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String phone;

}
