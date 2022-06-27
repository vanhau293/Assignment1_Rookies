package com.example.demo.services.impl;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import com.example.demo.data.dto.AuthorDto;
import com.example.demo.data.entities.AuthorEntity;
import com.example.demo.repositories.AuthorRepository;

public class AuthorServiceImplTest {
	AuthorServiceImpl authorServiceImpl;
	AuthorRepository authorRepository;
	ModelMapper modelMapper;
	AuthorDto authorRequest;
	AuthorDto authorResponse;
	AuthorEntity authorEntity;
	public AuthorServiceImplTest(){
		
	}
	@BeforeEach
	void beforeEach() {
		authorRepository = mock(AuthorRepository.class);
		modelMapper = mock(ModelMapper.class);
		authorServiceImpl = new AuthorServiceImpl(authorRepository,modelMapper);
		authorRequest = mock(AuthorDto.class);
		authorResponse =  mock(AuthorDto.class);
		authorEntity = mock(AuthorEntity.class);
		when(authorRepository.save(authorEntity)).thenReturn(authorEntity);
		when(modelMapper.map(authorRequest,AuthorEntity.class)).thenReturn(authorEntity);
		when(modelMapper.map(authorEntity, AuthorDto.class)).thenReturn(authorResponse);
	}
	@Test
	void addAuthor_ShouldReturnAuthor_WhenDataValid() {
//		AuthorDto request = new AuthorDto("1","Nguyen Van A");
//		AuthorDto result = authorServiceImpl.addAuthor(request);
//		assertThat(result).isEqualTo(authorResponse);
	}
		
}
