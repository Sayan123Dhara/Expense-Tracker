package com.spring.project.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.spring.project.entity.Expenses;

@Repository
public interface ExpensesRepo extends MongoRepository<Expenses, Integer>{

	List<Expenses> findByUsername(String userId);

}
