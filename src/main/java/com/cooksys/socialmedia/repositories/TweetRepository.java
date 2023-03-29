package com.cooksys.socialmedia.repositories;

import com.cooksys.socialmedia.entity.Credentials;
import com.cooksys.socialmedia.entity.Tweet;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, Long> {

	List<Tweet> findAllByDeletedFalse();

	Optional<Tweet> findAllByIdAndDeletedFalse(Long id);
	
	Optional<Tweet> findByIdAndDeletedFalse(Long id);
	
}
