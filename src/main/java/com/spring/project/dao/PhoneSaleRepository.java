package com.spring.project.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.spring.project.entity.Phonesale;

@Repository
public interface PhoneSaleRepository extends MongoRepository<Phonesale, Integer>{

	List<Phonesale> findByUsername(Object username);

}
