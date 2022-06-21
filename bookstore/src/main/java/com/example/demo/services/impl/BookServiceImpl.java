package com.example.demo.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.data.entities.BookEntity;
import com.example.demo.data.repositories.BookRepository;
import com.example.demo.dto.request.BookRequestDto;
import com.example.demo.dto.response.BookDetailsResponseDto;
import com.example.demo.dto.response.BookResponseDto;
import com.example.demo.exceptions.ResourceFoundException;
import com.example.demo.services.BookService;

@Service
public class BookServiceImpl implements BookService{
	@Autowired
	BookRepository bookRepository;
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public List<BookResponseDto> getAllBooks() { // get book in stock
		// TODO Auto-generated method stub
		List<BookEntity> list = bookRepository.findBooksInStock();
		List<BookResponseDto> dto = new ArrayList<BookResponseDto>();
		list.forEach(b -> dto.add(modelMapper.map(b, BookResponseDto.class)));
		return dto;
	}

	@Override
	public List<BookResponseDto> getBooksOutOfStock() { // get book out of stock
		// TODO Auto-generated method stub
		List<BookEntity> list = bookRepository.findBooksOutOfStock();
		List<BookResponseDto> dto = new ArrayList<BookResponseDto>();
		list.forEach(b -> dto.add(modelMapper.map(b, BookResponseDto.class)));
		return dto;
	}
	
	@Override
	public BookDetailsResponseDto getBook(int bookId) {
		// TODO Auto-generated method stub
		Optional<BookEntity> optional = bookRepository.findById(bookId);
		if(optional.isPresent()) {
			BookEntity book = optional.get();
			return modelMapper.map(book, BookDetailsResponseDto.class);
		}
		throw new ResourceFoundException("Book not found");
	}

	@Override
	public BookDetailsResponseDto addBook(BookRequestDto dto) {
		// TODO Auto-generated method stub
		BookEntity book = bookRepository.save(modelMapper.map(dto,BookEntity.class));
		return modelMapper.map(book, BookDetailsResponseDto.class);
	}

	@Override
	public BookDetailsResponseDto updateBook(int bookId, BookRequestDto dto) {
		// TODO Auto-generated method stub
		Optional<BookEntity> optional = bookRepository.findById(bookId);
		if(optional.isPresent()) {
			BookEntity book = optional.get();
			modelMapper.map(dto, book);
			System.out.println(book.getAuthorId().getAuthorName());
			book = bookRepository.save(book);
			
			return modelMapper.map(book, BookDetailsResponseDto.class);
		}
		throw new ResourceFoundException("Book not found");
	}

	@Override
	public boolean deleteBook(int bookId) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
