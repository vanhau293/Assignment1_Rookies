package com.example.demo.data.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.data.entities.BookEntity;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Integer>{
	public List<BookEntity> findBooksInStock();
	public List<BookEntity> findBooksOutOfStock();
}
