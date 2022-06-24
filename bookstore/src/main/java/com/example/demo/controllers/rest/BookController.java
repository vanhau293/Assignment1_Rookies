package com.example.demo.controllers.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dto.request.BookRequestDto;
import com.example.demo.dto.response.BookDetailsResponseDto;
import com.example.demo.dto.response.BookResponseDto;
import com.example.demo.services.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
	@Autowired
	private BookService bookService;
	
	@GetMapping("")
	public List<BookResponseDto> getAllBooks(){ // lay cac book in_stock = true
		return bookService.getAllBooks();
	}
	
	@GetMapping("/outofstock")
	public List<BookResponseDto> getBooksOutOfStock(){
		return null;
	}
	
	@GetMapping("/{id}")
	public BookDetailsResponseDto getBook(@PathVariable Integer id) {
		return bookService.getBook(id);
	}
	
	@PostMapping("")
	public BookDetailsResponseDto addBook(@Valid @RequestBody BookRequestDto book) {
		return bookService.addBook(book);
	}
	
	@PutMapping("/{id}")
	public BookDetailsResponseDto updateBook(@PathVariable Integer id, @Valid @RequestBody BookRequestDto book) {
		return bookService.updateBook(id, book);
	}
	
	@DeleteMapping("/id")
	public ResponseEntity<?> deleteBook(@PathVariable Integer id) {
		return bookService.deleteBook(id);
	}
	
}
