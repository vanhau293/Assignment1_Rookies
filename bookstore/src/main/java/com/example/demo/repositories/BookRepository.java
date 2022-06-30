package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.data.entities.BookEntity;
import com.example.demo.data.entities.ReviewEntity;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Integer>{
	public List<BookEntity> findBooksInStock();
	public List<BookEntity> findBooksOutOfStock();
	public List<ReviewEntity> findReviewByBookId(Integer bookId);
	public Optional<BookEntity> findByBookTitle(String bookTitle);
}
