package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.request.AuthorRequestDto;
import com.example.demo.dto.response.AuthorResponseDto;

public interface AuthorService {
	public List<AuthorResponseDto> getAllAuthors();
	public AuthorResponseDto addAuthor(AuthorRequestDto dto);
	public AuthorResponseDto updateAuthor(Integer authorId, AuthorRequestDto dto);
}
