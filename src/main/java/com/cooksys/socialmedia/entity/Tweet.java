package com.cooksys.socialmedia.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

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

    private Boolean deleted = false;

    private String content;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User inReplyTo;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User repostOf;

    @ManyToMany
    @JoinColumn(name = "hashtag_id")
    private List<Hashtag> hashtags;
}
