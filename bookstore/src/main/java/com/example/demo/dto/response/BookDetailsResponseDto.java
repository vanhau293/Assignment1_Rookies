package com.example.demo.dto.response;

import java.util.Collection;


public class BookDetailsResponseDto {

    private Float avgRating;
    private String description;
    private byte[] image;
    private long price;
    private String puslisher;
    private String bookTitle;
    private int totalPage;
    private boolean inStock;
    private AuthorResponseDto authorId;
    private CategoryResponseDto categoryId;
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
	public String getPuslisher() {
		return puslisher;
	}
	public void setPuslisher(String puslisher) {
		this.puslisher = puslisher;
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
	public Collection<ReviewResponseDto> getReviewsCollection() {
		return reviewsCollection;
	}
	public void setReviewsCollection(Collection<ReviewResponseDto> reviewsCollection) {
		this.reviewsCollection = reviewsCollection;
	}
    
}
