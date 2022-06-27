package com.example.demo.data.dto;

import com.example.demo.data.entities.ReviewPK;

public class ReviewDto {
	private String comment;
	private int starRating;
	private ReviewPK reviewPK;
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getStarRating() {
		return starRating;
	}
	public void setStarRating(int starRating) {
		this.starRating = starRating;
	}
	public ReviewPK getReviewPK() {
		return reviewPK;
	}
	public void setReviewPK(ReviewPK reviewPK) {
		this.reviewPK = reviewPK;
	}
	
}
