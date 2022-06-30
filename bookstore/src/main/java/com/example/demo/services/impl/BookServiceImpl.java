package com.example.demo.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.data.dto.BookDto;
import com.example.demo.data.dto.ReviewDto;
import com.example.demo.data.entities.AuthorEntity;
import com.example.demo.data.entities.BookEntity;
import com.example.demo.data.entities.CategoryEntity;
import com.example.demo.data.entities.CustomerEntity;
import com.example.demo.data.entities.ReviewEntity;
import com.example.demo.repositories.AuthorRepository;
import com.example.demo.repositories.BookRepository;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.repositories.CustomerRepository;
import com.example.demo.repositories.ReviewRepository;
import com.example.demo.response.MessageResponse;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.services.BookService;

@Service
public class BookServiceImpl implements BookService{
	
	private BookRepository bookRepository;
	private CategoryRepository categoryRepository;
	private AuthorRepository authorRepository;
	private ReviewRepository reviewRepository;
	private CustomerRepository customerRepository;
	private ModelMapper modelMapper;
	
	@Autowired
	public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository, CustomerRepository customerRepository, CategoryRepository categoryRepository, ReviewRepository reviewRepository, ModelMapper modelMapper) {
		this.reviewRepository = reviewRepository;
		this.bookRepository = bookRepository;
		this.authorRepository = authorRepository;
		this.customerRepository = customerRepository;
		this.categoryRepository = categoryRepository;
		this.modelMapper = modelMapper;
	}
	
	@Override
	public ResponseEntity<?> getAllBooks(boolean outStock) { // get book in stock
		// TODO Auto-generated method stub
		List<BookEntity> list;
		if(outStock == false) list= bookRepository.findBooksInStock();
		else list = bookRepository.findBooksOutOfStock();
		List<BookDto> dto = new ArrayList<BookDto>();
		list.forEach(b -> dto.add(modelMapper.map(b, BookDto.class)));
		return ResponseEntity.ok(dto);
	}

	@Override
	public BookDto getBook(int bookId) {
		// TODO Auto-generated method stub
		Optional<BookEntity> optional = bookRepository.findById(bookId);
		if(optional.isPresent()) {
			BookEntity book = optional.get();
			return modelMapper.map(book, BookDto.class);
		}
		throw new ResourceNotFoundException("Book not found");
	}

	@Override
	public ResponseEntity<?> addBook(BookDto dto) {
		// TODO Auto-generated method stub
		Optional<CategoryEntity> optionalCategory = categoryRepository.findByCategoryName(dto.getCategoryId().getCategoryName());
		if(!optionalCategory.isPresent()) {
			return ResponseEntity.badRequest().body(new MessageResponse("Category Name not found"));
		}
		Optional<AuthorEntity> optionalAuthor = authorRepository.findByAuthorName(dto.getAuthorId().getAuthorName());
		if(!optionalAuthor.isPresent()) {
			return ResponseEntity.badRequest().body(new MessageResponse("Author Name not found"));
		}
		Optional<BookEntity> optional = bookRepository.findByBookTitle(dto.getBookTitle().trim());
		if(optional.isPresent()) {
			return ResponseEntity.badRequest().body(new MessageResponse("Book Title is already taken"));
		}
		bookRepository.save(modelMapper.map(dto,BookEntity.class));
		return ResponseEntity.ok(new MessageResponse("The book was added successfully"));
	}

	@Override
	public ResponseEntity<?> updateBook(int bookId, BookDto dto) {
		// TODO Auto-generated method stub
		Optional<BookEntity> optionalBook = bookRepository.findById(bookId);
		if(!optionalBook.isPresent()) {
			throw new ResourceNotFoundException("Book not found");
		}
		Optional<CategoryEntity> optionalCategory = categoryRepository.findByCategoryName(dto.getCategoryId().getCategoryName());
		if(!optionalCategory.isPresent()) {
			return ResponseEntity.badRequest().body(new MessageResponse("Category not found"));
		}
		Optional<AuthorEntity> optionalAuthor = authorRepository.findByAuthorName(dto.getAuthorId().getAuthorName());
		if(!optionalAuthor.isPresent()) {
			return ResponseEntity.badRequest().body(new MessageResponse("Author not found"));
		}
		
		BookEntity book = optionalBook.get();
		book.setAuthorId(null);
		book.setCategoryId(null);
		modelMapper.map(dto, book);
		book = bookRepository.save(book);
		return ResponseEntity.ok(new MessageResponse("The book was updated successfully"));
	}

	@Override
	public ResponseEntity<?> deleteBook(int bookId) {
		// TODO Auto-generated method stub
		Optional<BookEntity> optional = bookRepository.findById(bookId);
		if(optional.isPresent()) {
			BookEntity book = optional.get();
			if(!book.isInStock()) {
				return ResponseEntity.badRequest().body(new MessageResponse("The book has been deleted before")) ;
			}
			else {
				book.setInStock(false);
				bookRepository.save(book);
				return ResponseEntity.ok(new MessageResponse("The book deleted successfully")) ;
			}
		}
		throw new ResourceNotFoundException("The book is not found");
	}

	@Override
	public ResponseEntity<?> getAllReviews(int bookId) {
		// TODO Auto-generated method stub
		Optional<BookEntity> optionalBook = bookRepository.findById(bookId);
		if(!optionalBook.isPresent()) {
			throw new ResourceNotFoundException("Book not found");
		}
		List<ReviewEntity> list = (List<ReviewEntity>) optionalBook.get().getReviewsCollection();
		List<ReviewDto> listDto = new ArrayList<ReviewDto>();
		list.forEach(r -> listDto.add(modelMapper.map(r, ReviewDto.class)));
		return ResponseEntity.ok(listDto);
	}

	@Override
	public ResponseEntity<?> addReview(ReviewDto dto) {
		// TODO Auto-generated method stub
		Optional<BookEntity> optionalBook = bookRepository.findById(dto.getReviewPK().getBookId());
		if(!optionalBook.isPresent()) {
			return ResponseEntity.badRequest().body(new MessageResponse("BookId of ReviewPK not found"));
		}
		Optional<CustomerEntity> optionalCustomer = customerRepository.findById(dto.getReviewPK().getCustomerId());
		if(!optionalCustomer.isPresent()) {
			return ResponseEntity.badRequest().body(new MessageResponse("CustomerId of ReviewPK not found"));
		}
		ReviewEntity review = modelMapper.map(dto, ReviewEntity.class);
		review = reviewRepository.save(review);
		return ResponseEntity.ok(review);
	}

	

}
