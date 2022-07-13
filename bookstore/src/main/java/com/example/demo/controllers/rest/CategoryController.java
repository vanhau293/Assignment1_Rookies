package com.example.demo.controllers.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.dto.CategoryDto;
import com.example.demo.services.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("")
	public List<CategoryDto> getAllCategories(@RequestParam(value="deleted", required= false) boolean isDeleted){
		if(isDeleted == false) return categoryService.getAllCategories();
		else return categoryService.getCategoriesDeleted();
	}
	@GetMapping("/{id}/books")
	public ResponseEntity<?> getBooksByCategoryId(@PathVariable("id") Integer categoryId){
		return categoryService.getBooksByCategoryId(categoryId);
	}
	@PostMapping("")
	public CategoryDto addCategory(@Valid @RequestBody CategoryDto dto) {
		return categoryService.addCategory(dto);
	}
	
	@PutMapping("/{id}")
	public CategoryDto updateCategory(@PathVariable Integer id, @Valid @RequestBody CategoryDto dto) {
		return categoryService.updateCategory(id, dto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCategory(@PathVariable Integer id) {
		return categoryService.deleteCategory(id);
	}
}
