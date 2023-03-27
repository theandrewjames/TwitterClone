package com.cooksys.socialmedia.repositories;

import com.cooksys.socialmedia.entity.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TweetRepository extends JpaRepository<Tweet, Long> {
}
