package com.cooksys.socialmedia.repositories;

import com.cooksys.socialmedia.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
