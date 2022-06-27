package com.example.demo.services;


import org.springframework.http.ResponseEntity;

import com.example.demo.data.dto.AuthorDto;

public interface AuthorService {
	public ResponseEntity<?> getAllAuthors();
	public ResponseEntity<?> addAuthor(AuthorDto dto);
	public ResponseEntity<?> updateAuthor(Integer authorId, AuthorDto dto);
}
