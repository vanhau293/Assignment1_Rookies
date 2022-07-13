package com.example.demo.data.dto;

import java.util.Collection;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;



public class BookDto {// use add book
	//@NotEmpty(message = "BookId must not be empty")
	@Pattern(regexp = "\\d*", message = "BookId must be a number")
	public String bookId;
	@NotEmpty(message = "Book title must not be empty")
	private String bookTitle;
	@NotEmpty(message = "Publisher must not be empty")
	private String publisher;
	@NotEmpty(message = "Descrption must not be empty")
	private String description;
	@NotEmpty(message = "Image must not be empty")
	private String image;
	@NotNull(message = "Price must not be null")
	@Min(value = 0, message = "Price >= 0")
	@Pattern(regexp = "\\d*", message = "Price must be a number")
	private String price;	
	@NotNull(message = "Total page must not be null")
	@Min(value = 0, message = "Total page >= 0")
	@Pattern(regexp = "\\d*", message = "Total page must be a number")
	private String totalPage;
    private boolean inStock;
    @NotNull(message = "Category must not be null")
    private CategoryForeignDto categoryId;
    @NotNull(message = "Author must not be null")
    private AuthorForeignDto authorId;
    private Float avgRating;
    public Collection<ReviewDto> reviewsCollection;
	
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public Float getAvgRating() {
		return avgRating;
	}
	public void setAvgRating(Float avgRating) {
		this.avgRating = avgRating;
	}
	
	public CategoryForeignDto getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(CategoryForeignDto categoryId) {
		this.categoryId = categoryId;
	}
	public AuthorForeignDto getAuthorId() {
		return authorId;
	}
	public void setAuthorId(AuthorForeignDto authorId) {
		this.authorId = authorId;
	}
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
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
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
	public void setReviewsCollection(Collection<ReviewDto> reviewsCollection) {
		this.reviewsCollection = reviewsCollection;
	}
	
	
		
}
