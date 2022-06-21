package com.example.demo.dto.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


public class BookRequestDto {// use add book
	@NotEmpty(message = "Descrption must not be empty")
	private String description;
	private byte[] image;
	@NotNull(message = "Price must not be null")
	@Min(value = 0, message = "Price >= 0")
	@Pattern(regexp = "\\d*", message = "Price must be a number")
	private String price;
	@NotEmpty(message = "Publisher must not be empty")
	private String publisher;
	@NotEmpty(message = "Book title must not be empty")
	private String bookTitle;
	@NotNull(message = "Total page must not be null")
	@Min(value = 0, message = "Total page >= 0")
	@Pattern(regexp = "\\d*", message = "Total page must be a number")
	private String totalPage;
    private boolean inStock;
	
	
	public boolean isInStock() {
		return inStock;
	}
	public void setInStock(boolean inStock) {
		this.inStock = inStock;
	}
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
