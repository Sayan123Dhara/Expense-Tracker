package com.spring.project.controller;

import java.io.Console;
import java.util.Optional; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus; 
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager; 
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken; 
import org.springframework.security.core.Authentication; 
import org.springframework.security.core.userdetails.UsernameNotFoundException; 
import org.springframework.web.bind.annotation.CrossOrigin; 
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController; 
import com.spring.security.*;
import com.spring.project.dao.UserRepository;
import com.spring.project.service.*; 
import com.spring.auth.User;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/auth")
@PropertySource("classpath:application.properties")
public class AuthController { 
	
	@Autowired 
	private UserService service ; 
	
	@Autowired 
	private JwtService jwtService ; 
	
	@Autowired 
	private UserRepository userRepo ; 
	
	@Autowired 
	private AuthenticationManager authenticationManager ; 
	
	

    @Value("${owner.username}")
    private String ownerUsername;

    @Value("${owner.password}")
    private String ownerPassword;
	
    @PostMapping("/login")
    public AuthResponse authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        // Check if the user is the owner with hardcoded credentials
        if (authRequest.getUserName().equals(ownerUsername) && authRequest.getPassword().equals(ownerPassword)) {
            // If the provided credentials match the owner's credentials
            String token = jwtService.generateToken(authRequest.getUserName());

            AuthResponse authResponse = new AuthResponse();
            authResponse.setToken(token);
            authResponse.setRole("OWNER");  // Set the role as per your role enum
            authResponse.setUsername(authRequest.getUserName());
            System.out.println(authResponse.getUsername() + " logged in..........");
            

            return authResponse;
        } else {
            // Proceed with regular authentication logic for non-owner users
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));

            if (authentication.isAuthenticated()) {
                Optional<User> fetchedUser = userRepo.findByUserName(authRequest.getUserName());

                if (fetchedUser.isPresent()) {
                    String role = fetchedUser.get().getRole().toString();
                    String token = jwtService.generateToken(authRequest.getUserName());

                    AuthResponse authResponse = new AuthResponse();
                    authResponse.setToken(token);
                    authResponse.setRole(role);
                    authResponse.setUsername(authRequest.getUserName());

                    return authResponse;
                } else {
                    throw new UsernameNotFoundException("Invalid user request!");
                }
            } else {
                throw new UsernameNotFoundException("Invalid User Request");
            }
        }
    }
	
	@PostMapping("/register") 
//	@PreAuthorize("hasAuthority('OWNER')")
	public ResponseEntity<HttpStatus> createUser(@RequestBody User user) { 
		System.out.println(user.toString());
		User u = service.createTheUser(user) ; 
		if(u!=null) 
			return new ResponseEntity<>(HttpStatus.CREATED) ; 
		else 
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE) ; 
		} 
	}

