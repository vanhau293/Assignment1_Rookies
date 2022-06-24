package com.example.demo.data.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.data.entities.CategoryEntity;
@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer>{
	public List<CategoryEntity> findCategories();
	public List<CategoryEntity> findCategoriesDeleted();
}
