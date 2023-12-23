package com.spring.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.auth.Role;
import com.spring.auth.User;
import com.spring.project.dao.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public User createTheUser(User user) {
        Role role = user.getRole();

        if (role == Role.OWNER) {
            User existingOwner = userRepo.findByRole(Role.OWNER);
            if (existingOwner == null) {
                user.setPassword(passwordEncoder.encode(user.getPassword()));
                return userRepo.save(user);
            } else {
                return null;
            }
        } else {
            User existingUser = userRepo.findByUserName(user.getUserName()).orElse(null);
            if (existingUser == null) {
                user.setPassword(passwordEncoder.encode(user.getPassword()));
                return userRepo.save(user);
            }
            return null;
        }
    }

    public List<User> getAllTheUsers() {
        try {
            return (List<User>) this.userRepo.findAll();
        } catch (Exception e) {
            return null;
        }
    }
}
