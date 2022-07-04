package com.example.demo.services.impl;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.demo.data.dto.AuthorDto;
import com.example.demo.data.entities.AuthorEntity;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repositories.AuthorRepository;


public class AuthorServiceImplTest {
	AuthorServiceImpl authorServiceImpl;
	AuthorRepository authorRepository;
	ModelMapper modelMapper;
	AuthorDto initialAuthor;
	AuthorEntity authorEntity;
	public AuthorServiceImplTest(){
		
	}
	@BeforeEach
	void beforeEach() {
		authorRepository = mock(AuthorRepository.class);
		modelMapper = mock(ModelMapper.class);
		authorServiceImpl = new AuthorServiceImpl(authorRepository,modelMapper);
		initialAuthor = mock(AuthorDto.class);
		authorEntity = mock(AuthorEntity.class);
		when(authorRepository.save(authorEntity)).thenReturn(authorEntity);
		when(modelMapper.map(initialAuthor,AuthorEntity.class)).thenReturn(authorEntity);
	}
	@Test
	void addAuthor_ShouldReturnStatusOk_WhenDataValid() {
		ResponseEntity<?> result = authorServiceImpl.addAuthor(initialAuthor);
		assertThat(result.getStatusCode(), is(HttpStatus.OK));
	}
	@Test
	void addAuthor_ShouldReturnStatus400_WhenAuthorNameAlrealyExist() {
		when(authorRepository.findByAuthorName(initialAuthor.getAuthorName())).thenReturn(Optional.of(authorEntity));
		ResponseEntity<?> result = authorServiceImpl.addAuthor(initialAuthor);
//		verify(authorRepository).findByAuthorName(initialAuthor.getAuthorName()); // verify hàm đã đc gọi hay chưa
		assertThat(result.getStatusCode(), is(HttpStatus.BAD_REQUEST));
	}
	@Test
	void updateAuthor_ShouldReturnStatusOk_WhenDataValid() {
		when(authorRepository.findById(1)).thenReturn(Optional.of(authorEntity));
		ResponseEntity<?> result = authorServiceImpl.updateAuthor(1, initialAuthor);
		assertThat(result.getStatusCode(), is(HttpStatus.OK));
	}
	@Test
	void updateAuthor_ShouldReturnStatusOk_WhenAuthorNotFound() {
		when(authorRepository.findById(1)).thenReturn(Optional.empty());
		ResourceNotFoundException exception = Assertions.assertThrows(ResourceNotFoundException.class,
                () -> authorServiceImpl.updateAuthor(1, initialAuthor));
        assertThat(exception.getMessage(), is("Author not found"));
		
		
	}
		
}
