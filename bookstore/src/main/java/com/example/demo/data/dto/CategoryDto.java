package com.example.demo.data.dto;

import javax.validation.constraints.NotEmpty;

public class CategoryDto {
	public String categoryId;
	@NotEmpty(message = "Category name must not be empty")
	private String categoryName;

	public boolean deleted;
	
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


	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	
}
