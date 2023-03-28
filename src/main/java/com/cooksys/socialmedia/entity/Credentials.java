package com.cooksys.socialmedia.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@Data
public class Credentials {
	
	@Column(unique = true)
    private String username;
	
    private String password;
}
