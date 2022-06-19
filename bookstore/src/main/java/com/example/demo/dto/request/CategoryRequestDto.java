package com.example.demo.dto.request;

import javax.validation.constraints.NotEmpty;

public class CategoryRequestDto {
	@NotEmpty(message = "Category name must not be null")
	private String categoryName;

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
}
