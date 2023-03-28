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
public class Tweet {
	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@Column(updatable = false, insertable = true)
	private Timestamp posted;

	private Boolean deleted;

	private String content;

	//@OneToOne
	//@JoinColumn(name = "tweet_id")
	//private Tweet inReplyTo;

	//@OneToOne
	//@JoinColumn(name = "tweet_id")
	//private Tweet repostOf;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "tweet_hashtags",
        joinColumns = @JoinColumn(name = "tweet_id"), inverseJoinColumns = @JoinColumn(name = "hashtag_id"))
    private Set<Hashtag> hashtags = new HashSet<>();
}
