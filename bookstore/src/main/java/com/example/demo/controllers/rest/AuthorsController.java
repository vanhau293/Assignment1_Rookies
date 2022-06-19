package com.example.demo.controllers.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.request.AuthorRequestDto;
import com.example.demo.dto.response.AuthorResponseDto;
import com.example.demo.services.AuthorService;

@RestController
@RequestMapping("/authors")
public class AuthorsController {
	
	@Autowired
	private AuthorService authorService;
	
	@GetMapping("")
	public List<AuthorResponseDto> getAllAuthors(){
		return authorService.getAllAuthors();
	}
	
	@PostMapping("")
	public AuthorResponseDto addAuthor(@Valid @RequestBody AuthorRequestDto dto) {
		return authorService.addAuthor(dto);
	}
	
	@PutMapping("/{id}")
	public AuthorResponseDto updateAuthor(@PathVariable("id") Integer id, @Valid @RequestBody AuthorRequestDto dto) {
			return authorService.updateAuthor(id, dto);
	}
}
