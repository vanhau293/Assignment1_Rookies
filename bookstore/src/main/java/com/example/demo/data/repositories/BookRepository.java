package com.example.demo.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.data.entities.BookEntity;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Integer>{

}
