package com.example.demo.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.data.dto.AuthorDto;
import com.example.demo.data.entities.AuthorEntity;


import com.example.demo.repositories.AuthorRepository;
import com.example.demo.response.MessageResponse;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.services.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService{

	
	private AuthorRepository authorRepository;
	private ModelMapper modelMapper;
	
	@Autowired
	public AuthorServiceImpl(AuthorRepository authorRepository, ModelMapper modelMapper) {
		this.authorRepository = authorRepository;
		this.modelMapper = modelMapper;
	}
			
	@Override
	public ResponseEntity<?> getAllAuthors() {
		// TODO Auto-generated method stub
		List<AuthorEntity> list = authorRepository.findAll();
		List<AuthorDto> listDto = new ArrayList<AuthorDto>();
		list.forEach(p -> listDto.add(modelMapper.map(p, AuthorDto.class)));
		return ResponseEntity.ok(listDto);
	}

	@Override
	public ResponseEntity<?> addAuthor(AuthorDto dto) {
		// TODO Auto-generated method stub
		Optional<AuthorEntity> optional = authorRepository.findByAuthorName(dto.getAuthorName());
		if(optional.isPresent()) {
			return ResponseEntity.badRequest().body(new MessageResponse("Author name already exists"));
		}
		authorRepository.save(modelMapper.map(dto, AuthorEntity.class));
		return ResponseEntity.ok(new MessageResponse("Add author successfully"));
	}

	@Override
	public ResponseEntity<?> updateAuthor(Integer authorId, AuthorDto dto) {
		// TODO Auto-generated method stub
		Optional<AuthorEntity> authorOptional = authorRepository.findById(authorId);
		if(authorOptional.isPresent()) {
			AuthorEntity author = authorOptional.get();
			modelMapper.map(dto,author);
			author = authorRepository.save(author);
			return ResponseEntity.ok(new MessageResponse("Update author successfully"));
		}
		throw new ResourceNotFoundException("Author not found");
	}
	

}
