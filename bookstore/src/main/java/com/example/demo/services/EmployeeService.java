package com.example.demo.services;


import org.springframework.http.ResponseEntity;

import com.example.demo.data.entities.EmployeeEntity;

public interface EmployeeService {
	public ResponseEntity<?> getAllEmployees();
	public ResponseEntity<?> getEmployee(Integer employeeId);
	public ResponseEntity<?> addEmployee(EmployeeEntity employee);
	public ResponseEntity<?> updateEmployee(Integer employeeId, EmployeeEntity employee);
	public ResponseEntity<?> deleteEmployee(Integer employeeId);
}
