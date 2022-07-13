package com.example.demo.data.dto;

import javax.validation.constraints.Pattern;

public class BookForeignDto {
	@Pattern(regexp = "\\d*", message = "BookId must be a number")
	private String bookId;
	public String bookTitle;
	public String image;
	public long price;
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
}
