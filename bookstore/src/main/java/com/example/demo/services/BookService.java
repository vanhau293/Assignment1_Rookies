package com.example.demo.services;

import java.util.List;

import com.example.demo.data.entities.BookEntity;
import com.example.demo.dto.request.BookRequestDto;
import com.example.demo.dto.response.BookResponseDto;


public interface BookService {
	public List<BookResponseDto> getAllBook();
	public BookEntity getBookEntity(int bookId);
	public BookResponseDto addBook(BookRequestDto book);
	public BookResponseDto updateBook(int bookId, BookRequestDto book);
	public boolean deleteBook(int bookId);
	
}
