package com.cooksys.socialmedia.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="user_table")
@NoArgsConstructor
@Data
public class User {

    @Id
    @GeneratedValue
    private Long id;
    
    @Embedded
    private Credentials credentials;
    
    @Embedded
    private Profile profile;    
  
    
    @Column(insertable = true, updatable = false)
    private Timestamp joined;
    
    private Boolean deleted = false;

    @OneToMany(mappedBy = "user")
    private List<Tweet> user_tweets;    

    
	@OneToMany
	@JoinTable(name = "user_mentions", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "tweet_id"))
	private Set<Tweet> reposted_tweets = new HashSet<>();
	
	@OneToMany
	@JoinTable(name = "user_likes", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "tweet_id"))
	private Set<Tweet> liked_tweets = new HashSet<>();


}
