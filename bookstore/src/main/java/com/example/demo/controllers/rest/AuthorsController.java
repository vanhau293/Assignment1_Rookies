package com.example.demo.controllers.rest;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.dto.AuthorDto;
import com.example.demo.services.AuthorService;

@RestController
@RequestMapping("/authors")
public class AuthorsController {
	
	@Autowired
	private AuthorService authorService;
	
	@GetMapping("")
	public ResponseEntity<?> getAllAuthors(){
		return authorService.getAllAuthors();
	}
	
	@PostMapping("")
	public ResponseEntity<?> addAuthor(@Valid @RequestBody AuthorDto dto) {
		return authorService.addAuthor(dto);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateAuthor(@PathVariable("id") Integer id, @Valid @RequestBody AuthorDto dto) {
			return authorService.updateAuthor(id, dto);
	}
}
