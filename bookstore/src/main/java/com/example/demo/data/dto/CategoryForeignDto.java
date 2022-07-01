package com.example.demo.data.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class CategoryForeignDto {
	@NotEmpty(message = "CategoryId must not be empty")
	@Pattern(regexp = "\\d*", message = "CategoryId must be a number")
	private String categoryId;
	
	public String categoryName;

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}


	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
}
