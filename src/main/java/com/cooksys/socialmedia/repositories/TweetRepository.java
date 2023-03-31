package com.cooksys.socialmedia.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cooksys.socialmedia.entity.Tweet;
import com.cooksys.socialmedia.entity.User;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, Long> {

	List<Tweet> findAllByDeletedFalse();

	Optional<Tweet> findAllByIdAndDeletedFalse(Long id);
	
	Optional<Tweet> findByIdAndDeletedFalse(Long id);
	
	List<Tweet> findByMentionedUsersContaining(User user);
	
}
