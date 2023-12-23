package com.spring.project.dao;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spring.auth.Role;
import com.spring.auth.User;

public interface UserRepository extends MongoRepository<User, Long>{
	User findByRole(Role role);
	Optional<User> findByUserName(String userName);
}
