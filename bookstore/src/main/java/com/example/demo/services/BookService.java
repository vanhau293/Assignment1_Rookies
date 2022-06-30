package com.example.demo.services;


import org.springframework.http.ResponseEntity;

import com.example.demo.data.dto.BookDto;
import com.example.demo.data.dto.ReviewDto;


public interface BookService {
	public ResponseEntity<?> getAllBooks(boolean outStock);
	public BookDto getBook(int bookId);
	public ResponseEntity<?> addBook(BookDto book);
	public ResponseEntity<?> updateBook(int bookId, BookDto book);
	public ResponseEntity<?> deleteBook(int bookId);
	
	public ResponseEntity<?> getAllReviews(int bookId);
	public ResponseEntity<?> addReview(ReviewDto dto);
}
