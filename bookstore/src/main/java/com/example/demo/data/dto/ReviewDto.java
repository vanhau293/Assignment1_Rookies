package com.example.demo.data.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.example.demo.data.entities.ReviewPK;

public class ReviewDto {
	@NotEmpty(message = "ReviewPK must not be empty")
	private ReviewPK reviewPK;
	public String createdDate;
	@NotEmpty(message = "Comment must not be empty")
	private String comment;
	@NotEmpty(message = "Star Rating must not be empty")
	@Pattern(regexp = "\\d*", message = "Star Rating must be a number")
	@Max(value = 5, message = "Star Rating <= 5")
	@Min(value = 1, message = "Star Rating >= 1")
	private String starRating;
	private CustomerForeignDto customerEntity;
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getStarRating() {
		return starRating;
	}
	public void setStarRating(String starRating) {
		this.starRating = starRating;
	}
	public ReviewPK getReviewPK() {
		return reviewPK;
	}
	public void setReviewPK(ReviewPK reviewPK) {
		this.reviewPK = reviewPK;
	}
	public CustomerForeignDto getCustomerEntity() {
		return customerEntity;
	}
	public void setCustomerEntity(CustomerForeignDto customerEntity) {
		this.customerEntity = customerEntity;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	
}
