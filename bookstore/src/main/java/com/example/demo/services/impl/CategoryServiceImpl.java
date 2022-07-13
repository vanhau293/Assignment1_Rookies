package com.example.demo.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.data.dto.BookDto;
import com.example.demo.data.dto.CategoryDto;
import com.example.demo.data.entities.BookEntity;
import com.example.demo.data.entities.CategoryEntity;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.response.MessageResponse;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public List<CategoryDto> getAllCategories() { //get categories deleted = false
		// TODO Auto-generated method stub
		List<CategoryEntity> list = categoryRepository.findCategories();
	
		List<CategoryDto> listDto = new ArrayList<CategoryDto>();
		list.forEach(c -> listDto.add(modelMapper.map(c, CategoryDto.class)));
		return listDto;
	}
	
	@Override
	public List<CategoryDto> getCategoriesDeleted() { // get Categories deleted = true;
		// TODO Auto-generated method stub
		List<CategoryEntity> list = categoryRepository.findCategoriesDeleted();
		List<CategoryDto> dto = new ArrayList<CategoryDto>();
		list.forEach(c -> dto.add(modelMapper.map(c, CategoryDto.class)));
		return dto;
	}

	@Override
	public CategoryDto addCategory(CategoryDto dto) {
		// TODO Auto-generated method stub
		CategoryEntity category = categoryRepository.save(modelMapper.map(dto, CategoryEntity.class));
		return modelMapper.map(category, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(Integer id, CategoryDto dto) {
		// TODO Auto-generated method stub
		Optional<CategoryEntity> categoryOptional = categoryRepository.findById(id);
		if(categoryOptional.isPresent()) {
			CategoryEntity category = categoryOptional.get();
			modelMapper.map(dto, category);
			category = categoryRepository.save(category);
			return modelMapper.map(category, CategoryDto.class);
		}
		throw new ResourceNotFoundException("Category not found");
	}

	@Override
	public ResponseEntity<?> deleteCategory(Integer id) {
		// TODO Auto-generated method stub
		Optional<CategoryEntity> optional = categoryRepository.findById(id);
		if(optional.isPresent()) {
			CategoryEntity category = optional.get();
			if(category.isDeleted()) {
				return ResponseEntity.badRequest().body(new MessageResponse("The category has been deleted before"));
			}
			else {
				category.setDeleted(true);
				categoryRepository.save(category);
				return ResponseEntity.ok(new MessageResponse("The category deleted successfully"));
			}
		}
		throw new ResourceNotFoundException("Category not found");
	}

	@Override
	public ResponseEntity<?> getBooksByCategoryId(Integer id) {
		// TODO Auto-generated method stub
		Optional<CategoryEntity> optional = categoryRepository.findById(id);
		if(!optional.isPresent()) {
			throw new ResourceNotFoundException("Category not found");
		}
		CategoryEntity category = optional.get();
		List<BookEntity> list = (List<BookEntity>) category.getBooksCollection();
		if(list.size()==0) {
			return ResponseEntity.badRequest().body(new MessageResponse("There are no books in this category"));
		}
		List<BookDto> listDto = new ArrayList<BookDto>();
		list.forEach(b -> {
			if(b.isInStock()) listDto.add(modelMapper.map(b, BookDto.class));
		});
		return ResponseEntity.ok(listDto);
	}

	
}
