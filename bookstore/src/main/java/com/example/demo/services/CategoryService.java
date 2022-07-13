package com.example.demo.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.data.dto.CategoryDto;

public interface CategoryService {
	public List<CategoryDto> getAllCategories();
	public List<CategoryDto> getCategoriesDeleted();
	public CategoryDto addCategory(CategoryDto dto);
	public CategoryDto updateCategory(Integer id, CategoryDto dto);
	public ResponseEntity<?> deleteCategory(Integer id);
	public ResponseEntity<?> getBooksByCategoryId(Integer id);
}
