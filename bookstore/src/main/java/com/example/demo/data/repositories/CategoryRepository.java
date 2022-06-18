package com.example.demo.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.data.entities.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer>{

}
