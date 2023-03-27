package com.cooksys.socialmedia.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@NoArgsConstructor
@Data
@Table(name="user_table")
public class User {

    @Id
    @GeneratedValue

    @OneToMany(mappedBy = "user")
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
}
