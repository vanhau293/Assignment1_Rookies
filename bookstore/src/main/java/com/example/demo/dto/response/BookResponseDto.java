package com.example.demo.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookResponseDto {
	private Integer bookId;
	private String bookTitle;
	private Float avgRating;
	private byte[] image;
	private long price;
	
	public BookResponseDto() {
		super();
	}
	public BookResponseDto(Integer bookId, String bookTitle, Float avgRating, byte[] image, long price) {
		super();
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.avgRating = avgRating;
		this.image = image;
		this.price = price;
	}
	
}
