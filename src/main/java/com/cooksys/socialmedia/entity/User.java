package com.cooksys.socialmedia.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

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
    private List<Tweet> tweets;

}
