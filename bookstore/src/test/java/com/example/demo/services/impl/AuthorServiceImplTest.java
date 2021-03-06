package com.example.demo.services.impl;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
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
	
	@BeforeEach
	void beforeEach() {
		authorRepository = mock(AuthorRepository.class);
		modelMapper = new ModelMapper();
		authorServiceImpl = new AuthorServiceImpl(authorRepository,modelMapper);
		initialAuthor = new AuthorDto("1","Nguyen");
		authorEntity = new AuthorEntity("Hau");
		
		when(authorRepository.save(authorEntity)).thenReturn(authorEntity);
		//when(modelMapper.map(initialAuthor,AuthorEntity.class)).thenReturn(authorEntity);
		
	}
	@Test
	void getAuthors_ShouldReturnList_WhenDataValid() {
		List<AuthorEntity> list = new ArrayList<AuthorEntity>();
		list.add(authorEntity);
		when(authorRepository.findAll()).thenReturn(list);
		ResponseEntity<?> result = authorServiceImpl.getAllAuthors();
		assertThat(((List<AuthorDto>)result.getBody()).size(), is(list.size()));
	}
	
	@Test
	void addAuthor_ShouldReturnStatusOk_WhenDataValid() {
		ResponseEntity<?> result = authorServiceImpl.addAuthor(initialAuthor);
		assertThat(result.getStatusCode(), is(HttpStatus.OK));
	}
	@Test
	void addAuthor_ShouldReturnStatus400_WhenAuthorNameAlrealyExist() {
		when(authorRepository.findByAuthorName("Nguyen")).thenReturn(Optional.of(authorEntity));
		ResponseEntity<?> result = authorServiceImpl.addAuthor(initialAuthor);
//		verify(authorRepository).findByAuthorName(initialAuthor.getAuthorName()); // verify h??m ???? ??c g???i hay ch??a
		assertThat(result.getStatusCode(), is(HttpStatus.BAD_REQUEST));
	}
	@Test
	void updateAuthor_ShouldReturnStatusOk_WhenDataValid() {
		when(authorRepository.findById(1)).thenReturn(Optional.of(authorEntity));
		ResponseEntity<?> result = authorServiceImpl.updateAuthor(1, initialAuthor);
		assertThat(result.getStatusCode(), is(HttpStatus.OK));
	}
	@Test
	void updateAuthor_ThrowNotFoundException_WhenAuthorNotFound() {
		when(authorRepository.findById(1)).thenReturn(Optional.empty());
		ResourceNotFoundException exception = Assertions.assertThrows(ResourceNotFoundException.class,
                () -> authorServiceImpl.updateAuthor(1, initialAuthor));
        assertThat(exception.getMessage(), is("Author not found"));
		
		
	}
		
}
