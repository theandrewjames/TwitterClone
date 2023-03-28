package com.cooksys.socialmedia.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@NoArgsConstructor
@Data
public class Hashtag {
	@Id
	@GeneratedValue
	private Long id;

	@Column(unique = true)
	private String label;

	@Column(updatable = false, insertable = true)
	private Timestamp firstUsed;

	@Column(updatable = true)
	private Timestamp lastUsed;

	@ManyToMany(mappedBy = "hashtags")
	private Set<Tweet> tweets = new HashSet<>();

}
