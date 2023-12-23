package com.spring.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.client.MongoClient;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@ComponentScan(basePackages = "com.spring")
public class ProjectTrackerApplication {

	private static MongoClient mongoClient;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjectTrackerApplication.class, args);
		
		
		
	}
	


}
