package com.example.demo.data.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.example.demo.data.entities.ReviewPK;

public class ReviewDto {
	@NotEmpty(message = "Created Date must not be empty")
	//2022-06-28T12:25:32.020
	@Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}.\\d*", 
	message = "Created date must be a day like (yyyy-MM-ddTHH:mm:ss.SSS)")
	private String createdDate;
	@NotEmpty(message = "Comment must not be empty")
	private String comment;
	@NotEmpty(message = "Star Rating must not be empty")
	@Pattern(regexp = "\\d*", message = "Star Rating must be a number")
	@Max(value = 5, message = "Star Rating <= 5")
	@Min(value = 1, message = "Star Rating >= 1")
	private String starRating;
	@NotEmpty(message = "ReviewPK must not be empty")
	private ReviewPK reviewPK;
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
	
}
