package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.data.entities.AuthorEntity;
@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity, Integer> {
	public Optional<AuthorEntity> findByAuthorName(String authorName);
}
