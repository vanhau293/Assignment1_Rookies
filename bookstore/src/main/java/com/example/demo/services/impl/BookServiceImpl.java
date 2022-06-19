package com.example.demo.services.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.data.repositories.BookRepository;
import com.example.demo.dto.request.BookRequestDto;
import com.example.demo.dto.response.BookDetailsResponseDto;
import com.example.demo.dto.response.BookResponseDto;
import com.example.demo.services.BookService;

@Service
public class BookServiceImpl implements BookService{
	@Autowired
	BookRepository bookRepository;
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public List<BookResponseDto> getAllBooks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookDetailsResponseDto getBook(int bookId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookResponseDto addBook(BookRequestDto book) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookResponseDto updateBook(int bookId, BookRequestDto book) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteBook(int bookId) {
		// TODO Auto-generated method stub
		return false;
	}

}
