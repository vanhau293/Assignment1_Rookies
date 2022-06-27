package com.example.demo.controllers.rest;


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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.dto.BookDto;
import com.example.demo.services.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
	@Autowired
	private BookService bookService;
	
	@GetMapping("")
	public ResponseEntity<?> getAllBooks(@RequestParam(value="outstock", required= false) boolean outStock){
		return bookService.getAllBooks(outStock);
	}
	
	
	@GetMapping("/{id}")
	public BookDto getBookById(@PathVariable Integer id) {
		return bookService.getBook(id);
	}
	
	@PostMapping("")
	public ResponseEntity<?> addBook(@Valid @RequestBody BookDto book) {
		return bookService.addBook(book);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateBook(@PathVariable Integer id, @Valid @RequestBody BookDto book) {
		return bookService.updateBook(id, book);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteBook(@PathVariable Integer id) {
		return bookService.deleteBook(id);
	}
	
}
