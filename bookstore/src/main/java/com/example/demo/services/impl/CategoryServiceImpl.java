package com.example.demo.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.data.entities.CategoryEntity;
import com.example.demo.data.repositories.CategoryRepository;
import com.example.demo.dto.request.CategoryRequestDto;
import com.example.demo.dto.response.CategoryResponseDto;
import com.example.demo.exceptions.ResourceFoundException;
import com.example.demo.payload.response.MessageResponse;
import com.example.demo.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public List<CategoryResponseDto> getAllCategories() { //get categories deleted = false
		// TODO Auto-generated method stub
		List<CategoryEntity> list = categoryRepository.findCategories();
		List<CategoryResponseDto> listDto = new ArrayList<CategoryResponseDto>();
		list.forEach(c -> listDto.add(modelMapper.map(c, CategoryResponseDto.class)));
		return listDto;
	}
	
	@Override
	public List<CategoryResponseDto> getCategoriesDeleted() { // get Categories deleted = true;
		// TODO Auto-generated method stub
		List<CategoryEntity> list = categoryRepository.findCategoriesDeleted();
		List<CategoryResponseDto> dto = new ArrayList<CategoryResponseDto>();
		list.forEach(c -> dto.add(modelMapper.map(c, CategoryResponseDto.class)));
		return dto;
	}

	@Override
	public CategoryResponseDto addCategory(CategoryRequestDto dto) {
		// TODO Auto-generated method stub
		CategoryEntity category = categoryRepository.save(modelMapper.map(dto, CategoryEntity.class));
		return modelMapper.map(category, CategoryResponseDto.class);
	}

	@Override
	public CategoryResponseDto updateCategory(Integer id, CategoryRequestDto dto) {
		// TODO Auto-generated method stub
		Optional<CategoryEntity> categoryOptional = categoryRepository.findById(id);
		if(categoryOptional.isPresent()) {
			CategoryEntity category = categoryOptional.get();
			modelMapper.map(dto, category);
			category = categoryRepository.save(category);
			return modelMapper.map(category, CategoryResponseDto.class);
		}
		throw new ResourceFoundException("Category not found");
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
		throw new ResourceFoundException("Category is not found");
	}

	
}
