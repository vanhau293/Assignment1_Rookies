package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.data.entities.CategoryEntity;
@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer>{
	public List<CategoryEntity> findCategories();
	public Optional<CategoryEntity> findByCategoryName(String categoryName);
	public List<CategoryEntity> findCategoriesDeleted();
}
