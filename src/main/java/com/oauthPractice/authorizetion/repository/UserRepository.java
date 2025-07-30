package com.oauthPractice.authorizetion.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.oauthPractice.authorizetion.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByUsername(String username);
}
