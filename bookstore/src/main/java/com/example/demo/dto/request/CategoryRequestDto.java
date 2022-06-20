package com.example.demo.dto.request;

import javax.validation.constraints.NotEmpty;

public class CategoryRequestDto {
	@NotEmpty(message = "Category name must not be empty")
	private String categoryName;

	private boolean deleted;
	
	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	
}
