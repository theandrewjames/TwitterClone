package com.cooksys.socialmedia.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cooksys.socialmedia.entity.Credentials;
import com.cooksys.socialmedia.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByCredentials(Credentials credentials);
	
	Optional<User> findByCredentialsAndDeletedFalse(Credentials credentials);
	
	Optional<User> findByCredentialsUsername(String username);
	
	List<User> findByFollowingAndDeletedFalse(User user);
	
	List<User> findByFollowersAndDeletedFalse(User user);
	
}
