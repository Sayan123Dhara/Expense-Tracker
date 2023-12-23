package com.spring.project.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.spring.project.entity.EMI;

@Repository
public interface EMIRepo extends MongoRepository<EMI, Integer>{

	List<EMI> findByUsername(Object username);

}
