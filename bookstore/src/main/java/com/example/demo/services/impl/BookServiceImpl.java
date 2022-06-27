package com.example.demo.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.data.dto.BookDto;
import com.example.demo.data.entities.BookEntity;
import com.example.demo.repositories.BookRepository;
import com.example.demo.response.MessageResponse;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.services.BookService;

@Service
public class BookServiceImpl implements BookService{
	@Autowired
	BookRepository bookRepository;
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public ResponseEntity<?> getAllBooks(boolean outStock) { // get book in stock
		// TODO Auto-generated method stub
		List<BookEntity> list;
		if(outStock == false) list= bookRepository.findBooksInStock();
		else list = bookRepository.findBooksOutOfStock();
		List<BookDto> dto = new ArrayList<BookDto>();
		list.forEach(b -> dto.add(modelMapper.map(b, BookDto.class)));
		return ResponseEntity.ok(dto);
	}

	@Override
	public BookDto getBook(int bookId) {
		// TODO Auto-generated method stub
		Optional<BookEntity> optional = bookRepository.findById(bookId);
		if(optional.isPresent()) {
			BookEntity book = optional.get();
			return modelMapper.map(book, BookDto.class);
		}
		throw new ResourceNotFoundException("Book not found");
	}

	@Override
	public ResponseEntity<?> addBook(BookDto dto) {
		// TODO Auto-generated method stub
		bookRepository.save(modelMapper.map(dto,BookEntity.class));
		return ResponseEntity.ok(new MessageResponse("The book was added successfully"));
	}

	@Override
	public ResponseEntity<?> updateBook(int bookId, BookDto dto) {
		// TODO Auto-generated method stub
		Optional<BookEntity> optional = bookRepository.findById(bookId);
		if(optional.isPresent()) {
			BookEntity book = optional.get();
			modelMapper.map(dto, book);
			System.out.println(book.getAuthorId().getAuthorName());
			book = bookRepository.save(book);
			
			return ResponseEntity.ok(new MessageResponse("The book was updated successfully"));
		}
		throw new ResourceNotFoundException("Book not found");
	}

	@Override
	public ResponseEntity<?> deleteBook(int bookId) {
		// TODO Auto-generated method stub
		Optional<BookEntity> optional = bookRepository.findById(bookId);
		if(optional.isPresent()) {
			BookEntity book = optional.get();
			if(!book.isInStock()) {
				return ResponseEntity.badRequest().body(new MessageResponse("The book has been deleted before")) ;
			}
			else {
				book.setInStock(false);
				bookRepository.save(book);
				return ResponseEntity.ok(new MessageResponse("The book deleted successfully")) ;
			}
		}
		throw new ResourceNotFoundException("The book is not found");
	}

	

}
