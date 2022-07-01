package com.example.demo.data.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class BookForeignDto {
	@NotEmpty(message = "BookId must not be empty")
	@Pattern(regexp = "\\d*", message = "BookId must be a number")
	private String bookId;
	public String bookTitle;
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	
}
