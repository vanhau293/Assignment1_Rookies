package com.example.demo.services.impl;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import com.example.demo.data.dto.BookDto;
import com.example.demo.data.entities.BookEntity;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repositories.AuthorRepository;
import com.example.demo.repositories.BookRepository;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.repositories.CustomerRepository;
import com.example.demo.repositories.ReviewRepository;

public class BookServiceImplTest {

	private BookRepository bookRepository;
	private CategoryRepository categoryRepository;
	private AuthorRepository authorRepository;
	private ReviewRepository reviewRepository;
	private CustomerRepository customerRepository;
	private ModelMapper modelMapper;
	private BookServiceImpl bookServiceImpl;
	private BookDto bookDto;
	private BookEntity bookEntity;
	
	@BeforeEach
	public void beforeEach() {
		bookRepository = mock(BookRepository.class);
		categoryRepository = mock(CategoryRepository.class);
		authorRepository = mock(AuthorRepository.class);
		reviewRepository = mock(ReviewRepository.class);
		customerRepository = mock(CustomerRepository.class);
		modelMapper = mock(ModelMapper.class);
		
		bookServiceImpl = new BookServiceImpl(bookRepository, authorRepository, customerRepository, categoryRepository, reviewRepository, modelMapper);
		bookDto = mock(BookDto.class);
		bookEntity = mock(BookEntity.class);
		
	}
	@Test
	public void getAllBooks_ShouldReturnListBookDto_WhenOutStockTrue() {
		List<BookEntity> list = new ArrayList<BookEntity>();
		list.add(bookEntity);
		when(modelMapper.map(bookEntity, BookDto.class)).thenReturn(bookDto);
		when(bookRepository.findBooksOutOfStock()).thenReturn(list);
		List<BookDto> result = bookServiceImpl.getAllBooks(true);
		assertThat(result.size(), is(list.size()));
	}
	@Test
	public void getAllBooks_ShouldReturnListBookDto_WhenOutStockFalse() {
		List<BookEntity> list = new ArrayList<BookEntity>();
		list.add(bookEntity);
		when(modelMapper.map(bookEntity, BookDto.class)).thenReturn(bookDto);
		when(bookRepository.findBooksInStock()).thenReturn(list);
		List<BookDto> result = bookServiceImpl.getAllBooks(false);
		assertThat(result.size(), is(list.size()));
	}
	@Test
	public void getBook_ShouldReturnBookDto_WhenDataValid() {
		when(bookRepository.findById(1)).thenReturn(Optional.of(bookEntity));
		when(modelMapper.map(bookEntity, BookDto.class)).thenReturn(bookDto);
		BookDto result = bookServiceImpl.getBook(1);
		assertThat(result, is(bookDto));
	}
	@Test
	public void getBook_ShouldThrowResourceNotFoundException_WhenBookIdNotFound() {
		when(bookRepository.findById(1)).thenReturn(Optional.empty());
		ResourceNotFoundException exception = Assertions.assertThrows(ResourceNotFoundException.class, 
				() -> bookServiceImpl.getBook(1));
		assertThat(exception.getMessage(), is("Book not found"));
	}
}
