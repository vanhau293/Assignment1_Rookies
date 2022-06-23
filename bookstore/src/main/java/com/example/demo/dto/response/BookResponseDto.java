package com.example.demo.dto.response;


public class BookResponseDto {
	private Integer bookId;
	private String bookTitle;
	private Float avgRating;
	private byte[] image;
	private long price;
	private AuthorResponseDto authorId;
	private CategoryResponseDto categoryId;
	
	public AuthorResponseDto getAuthorId() {
		return authorId;
	}
	public void setAuthorId(AuthorResponseDto authorId) {
		this.authorId = authorId;
	}
	public CategoryResponseDto getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(CategoryResponseDto categoryId) {
		this.categoryId = categoryId;
	}
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
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public Float getAvgRating() {
		return avgRating;
	}
	public void setAvgRating(Float avgRating) {
		this.avgRating = avgRating;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	
	
}
