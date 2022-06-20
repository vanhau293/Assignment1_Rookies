package com.example.demo.data.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.data.entities.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer>{
	public List<CategoryEntity> findCategories();
	public List<CategoryEntity> findCategoriesDeleted();
}
