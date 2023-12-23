package com.spring.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.auth.User;
import com.spring.project.dao.UserRepository;

@Service
public class UserInfoUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Attempting to load user by username: " + username);
        
        Optional<User> userInfo = repository.findByUserName(username);
        
        if (userInfo.isPresent()) {
            System.out.println("User found: " + userInfo.get());
            return userInfo.map(UserInfoUserDetails::new).get();
        } else {
            System.out.println("User not found with username: " + username);
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }

}
