package com.example.demo.controllers.rest;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.request.CategoryRequestDto;
import com.example.demo.dto.response.CategoryResponseDto;
import com.example.demo.services.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("")
	public List<CategoryResponseDto> getAllCategories(){
		return categoryService.getAllCategories();
	}
	
	@PostMapping("")
	public CategoryResponseDto addCategory(@Valid @RequestBody CategoryRequestDto dto) {
		return categoryService.addCategory(dto);
	}
	
	@PutMapping("/{id}")
	public CategoryResponseDto updateCategory(@PathVariable Integer id, @Valid @RequestBody CategoryRequestDto dto) {
		return categoryService.updateCategory(id, dto);
	}
	
	@DeleteMapping("/{id}")
	public boolean deleteCategory(@PathVariable Integer id) {
		return categoryService.deleteCategory(id);
	}
}
