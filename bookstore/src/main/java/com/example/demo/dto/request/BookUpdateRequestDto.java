package com.example.demo.dto.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;


public class BookUpdateRequestDto {
	private String description;
	private byte[] image;
	@Pattern(regexp = "\\d*", message = "Price must be a number")
	@Min(value = 0, message = "Price >= 0")
	private String price;
	private String publisher;
	private String bookTitle;
	@Pattern(regexp = "\\d*", message = "Total page must be a number")
	@Min(value = 0, message = "Total page >= 0")
	private String totalPage;
	
//	@Pattern(regexp = "\\d*", message = "Total page must be a number")
//	@Min(value = 0, message = "Total page >= 0")
//	private AuthorRequestDto authorId;
//	private CategoryRequestDto categoryId;
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public String getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(String totalPage) {
		this.totalPage = totalPage;
	}
	
	
}
