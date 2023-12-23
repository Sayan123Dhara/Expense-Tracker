package com.spring.project;

import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.mongodb.client.MongoClient;
import com.spring.auth.Role;
import com.spring.auth.User;
import com.spring.project.dao.UserRepository;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@ComponentScan(basePackages = "com.spring")
public class ProjectTrackerApplication {

	private static MongoClient mongoClient;

	@Autowired UserRepository userRepository;
	@Autowired PasswordEncoder passwordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjectTrackerApplication.class, args);
	}

	@PostConstruct
	public void init(){
		System.out.println("Working");
        Optional<User> fetchedUser = userRepository.findByUserName("admin");
        System.out.println(fetchedUser + " data before if loadeed ");
        if(!fetchedUser.isPresent()){
            User owner = new User();
            owner.setPassword(passwordEncoder.encode("adminPassword"));
            owner.setRole(Role.OWNER);
            owner.setUserName("admin");
            userRepository.save(owner);
            System.out.println("data saved in database");
        }
	}
}
