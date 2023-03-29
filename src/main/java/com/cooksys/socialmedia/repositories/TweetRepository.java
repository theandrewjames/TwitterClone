package com.cooksys.socialmedia.repositories;

import com.cooksys.socialmedia.entity.Tweet;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, Long> {

	//List<Tweet> findAllByDeletedFalse();
}
