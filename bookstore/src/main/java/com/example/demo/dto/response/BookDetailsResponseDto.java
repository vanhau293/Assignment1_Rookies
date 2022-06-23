package com.example.demo.dto.response;

import java.util.Collection;


public class BookDetailsResponseDto {
	private String bookTitle;
	private AuthorResponseDto authorId;
    private CategoryResponseDto categoryId;
    private long price;
    private String publisher;
    private byte[] image;
    private Float avgRating;
    private String description;
    
    
    
    private int totalPage;
    private boolean inStock;
    
    private Collection<ReviewResponseDto> reviewsCollection;
	public Float getAvgRating() {
		return avgRating;
	}
	public void setAvgRating(Float avgRating) {
		this.avgRating = avgRating;
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
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
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
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public boolean isInStock() {
		return inStock;
	}
	public void setInStock(boolean inStock) {
		this.inStock = inStock;
	}
	
	public Collection<ReviewResponseDto> getReviewsCollection() {
		return reviewsCollection;
	}
	public void setReviewsCollection(Collection<ReviewResponseDto> reviewsCollection) {
		this.reviewsCollection = reviewsCollection;
	}
	public void setAuthorId(AuthorResponseDto authorId) {
		this.authorId = authorId;
	}
	public void setCategoryId(CategoryResponseDto categoryId) {
		this.categoryId = categoryId;
	}
	public AuthorResponseDto getAuthorId() {
		return authorId;
	}
	public CategoryResponseDto getCategoryId() {
		return categoryId;
	}
	
    
}
