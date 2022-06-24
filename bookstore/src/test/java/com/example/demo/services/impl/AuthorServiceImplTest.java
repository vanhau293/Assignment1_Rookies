package com.example.demo.services.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import com.example.demo.data.entities.AuthorEntity;
import com.example.demo.data.repositories.AuthorRepository;
import com.example.demo.dto.request.AuthorRequestDto;
import com.example.demo.dto.response.AuthorResponseDto;

public class AuthorServiceImplTest {
	AuthorServiceImpl authorServiceImpl;
	AuthorRepository authorRepository;
	ModelMapper modelMapper;
	AuthorRequestDto authorRequestDto;
	AuthorResponseDto authorResponseDto;
	AuthorEntity authorEntity;
	public AuthorServiceImplTest(){
		
	}
	@BeforeEach
	void beforeEach() {
		authorRepository = mock(AuthorRepository.class);
		modelMapper = mock(ModelMapper.class);
		authorServiceImpl = new AuthorServiceImpl(authorRepository,modelMapper);
		authorRequestDto = mock(AuthorRequestDto.class);
		authorResponseDto =  mock(AuthorResponseDto.class);
		authorEntity = mock(AuthorEntity.class);
		when(authorRepository.save(authorEntity)).thenReturn(authorEntity);
		when(modelMapper.map(authorRequestDto,AuthorEntity.class)).thenReturn(authorEntity);
		when(modelMapper.map(authorEntity, AuthorResponseDto.class)).thenReturn(authorResponseDto);
	}
	@Test
	void addAuthor_ShouldReturnAuthor_WhenDataValid() {
		AuthorRequestDto request = new AuthorRequestDto("1","Nguyen Van A");
		AuthorResponseDto result = authorServiceImpl.addAuthor(request);
		assertThat(result).isEqualTo(authorResponseDto);
	}
		
}
