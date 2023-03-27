package com.cooksys.socialmedia.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@Table(name="user_table")
public class User {

    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String username;
    private String password;
    @Column(updatable = false, insertable = true)
    private Timestamp joined;
    private Boolean deleted = false;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    @OneToMany(mappedBy = "tweet")
    private List<Tweet> tweets;

    @Embedded
    Credentials credentials;
    @Embedded
    Profile profile;
}
