package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.data.entities.ReviewEntity;
import com.example.demo.data.entities.ReviewPK;
@Repository
public interface ReviewRepository extends JpaRepository<ReviewEntity, ReviewPK>{

}
