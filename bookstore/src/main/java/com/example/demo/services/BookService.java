package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.request.BookRequestDto;
import com.example.demo.dto.response.BookDetailsResponseDto;
import com.example.demo.dto.response.BookResponseDto;


public interface BookService {
	public List<BookResponseDto> getAllBooks(); // GET INSTOCK = TRUE
	public List<BookResponseDto> getBooksOutOfStock();
	public BookDetailsResponseDto getBook(int bookId);
	public BookDetailsResponseDto addBook(BookRequestDto book);
	public BookDetailsResponseDto updateBook(int bookId, BookRequestDto book);
	public boolean deleteBook(int bookId);
	
}
