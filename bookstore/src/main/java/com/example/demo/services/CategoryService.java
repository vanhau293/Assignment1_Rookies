package com.example.demo.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.dto.request.CategoryRequestDto;
import com.example.demo.dto.response.CategoryResponseDto;

public interface CategoryService {
	public List<CategoryResponseDto> getAllCategories();
	public List<CategoryResponseDto> getCategoriesDeleted();
	public CategoryResponseDto addCategory(CategoryRequestDto dto);
	public CategoryResponseDto updateCategory(Integer id, CategoryRequestDto dto);
	public ResponseEntity<?> deleteCategory(Integer id);
}
