package com.example.demo.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.data.entities.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer>{

}
