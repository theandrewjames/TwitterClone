package com.cooksys.socialmedia.repositories;

import com.cooksys.socialmedia.entity.Credentials;
import com.cooksys.socialmedia.entity.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByCredentials(Credentials credentials);

}
