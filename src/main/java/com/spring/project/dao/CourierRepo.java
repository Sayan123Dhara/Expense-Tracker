package com.spring.project.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.spring.project.entity.Courier;

@Repository
public interface CourierRepo extends MongoRepository<Courier, Integer>{

	List<Courier> findByUsername(Object username);
	

}
