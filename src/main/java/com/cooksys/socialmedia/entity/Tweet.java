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
	
	@ManyToOne
	@JoinColumn(name = "inReplyTo")
	private Tweet inReplyTo;
	
	@OneToMany(mappedBy = "inReplyTo")
	private List<Tweet> replies; 
	
	@ManyToOne
	@JoinColumn(name = "repostOf")
	private Tweet repostOf;
	
	@OneToMany(mappedBy = "repostOf")
	private List<Tweet> reposts; 
	
	@ManyToMany(mappedBy = "reposted_tweets")
	private Set<User> user_mentions  = new HashSet<>();
	
	@ManyToMany(mappedBy = "liked_tweets")
	private Set<User> user_likes  = new HashSet<>();

	@ManyToMany
    @JoinTable(name = "tweet_hashtags",
        joinColumns = @JoinColumn(name = "tweet_id"), inverseJoinColumns = @JoinColumn(name = "hashtag_id"))
    private Set<Hashtag> hashtags = new HashSet<>();
}
