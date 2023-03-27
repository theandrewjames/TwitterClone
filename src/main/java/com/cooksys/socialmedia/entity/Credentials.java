package com.cooksys.socialmedia.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class Credentials {
    private String username;
    private String password;
}
