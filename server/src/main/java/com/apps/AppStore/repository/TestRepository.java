package com.apps.AppStore.repository;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.apps.AppStore.pojo.AppDetails;

public interface TestRepository extends MongoRepository<Book, String> {
 
	Optional<Book> findById(String titleContains);
 
}