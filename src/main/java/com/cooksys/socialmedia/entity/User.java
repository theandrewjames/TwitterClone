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
	
	@Embeddable
	public class Credentials {
		
		@Column(unique = true)
	    private String username;
		
	    private String password;
	}
	
	@Embeddable
	public class Profile {
	    private String firstName;
	    private String lastName;
	    private String email;
	    private String phone;
	}

    @Id
    @GeneratedValue
    private Long id;
    
    @Embedded
    private Credentials credentials;
    
    @Embedded
    private Profile profile;    
  
    
    @Column(insertable = true, updatable = false)
    private Timestamp joined;
    
    private Boolean deleted;

    @OneToMany(mappedBy = "user")
    private List<Tweet> user_tweets;    

    
	@ManyToMany
	@JoinTable(name = "user_mentions", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "tweet_id"))
	private Set<Tweet> reposted_tweets = new HashSet<>();
	
	@ManyToMany
	@JoinTable(name = "user_likes", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "tweet_id"))
	private Set<Tweet> liked_tweets = new HashSet<>();
	

	@ManyToMany
	@JoinTable(name = "followers_following", joinColumns = @JoinColumn(name = "follower_id"), inverseJoinColumns = @JoinColumn(name = "following_id"))
	private Set<User> following; 
	
	@ManyToMany(mappedBy = "following")
	private Set<User> followers;



}
