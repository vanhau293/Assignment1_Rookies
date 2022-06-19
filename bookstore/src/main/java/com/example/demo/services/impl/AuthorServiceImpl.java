package com.example.demo.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.data.entities.AuthorEntity;


import com.example.demo.data.repositories.AuthorRepository;
import com.example.demo.dto.request.AuthorRequestDto;
import com.example.demo.dto.response.AuthorResponseDto;
import com.example.demo.exceptions.ResourceFoundException;
import com.example.demo.services.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService{

	@Autowired
	private AuthorRepository authorRepository;
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public List<AuthorResponseDto> getAllAuthors() {
		// TODO Auto-generated method stub
		List<AuthorEntity> list = authorRepository.findAll();
		List<AuthorResponseDto> listDto = new ArrayList<AuthorResponseDto>();
		list.forEach(p -> listDto.add(modelMapper.map(p, AuthorResponseDto.class)));
		return listDto;
	}

	@Override
	public AuthorResponseDto addAuthor(AuthorRequestDto dto) {
		// TODO Auto-generated method stub
		AuthorEntity author = authorRepository.save(modelMapper.map(dto, AuthorEntity.class));
		return modelMapper.map(author, AuthorResponseDto.class);
	}

	@Override
	public AuthorResponseDto updateAuthor(Integer authorId, AuthorRequestDto dto) {
		// TODO Auto-generated method stub
		Optional<AuthorEntity> authorOptional = authorRepository.findById(authorId);
		if(authorOptional.isPresent()) {
			AuthorEntity author = authorOptional.get();
			modelMapper.map(dto,author);
			author = authorRepository.save(author);
			return modelMapper.map(author, AuthorResponseDto.class);
		}
		throw new ResourceFoundException("AuthorId not found");
	}
	

}
