package com.cooksys.socialmedia.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@NoArgsConstructor
@Data
public class Tweet {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Integer author;
    @Column(updatable = false, insertable = true)
    private Timestamp posted;
    private Boolean deleted = false;
    private String content;
    private Integer inReplyTo;
    private Integer repostOf;
}
