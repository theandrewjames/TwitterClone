package com.cooksys.socialmedia.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    private Long id;
    private String username;
    private String password;
    private Timestamp joined;
    private Boolean deleted = false;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}
