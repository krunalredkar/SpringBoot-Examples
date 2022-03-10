package com.h2.example.service;

import java.util.List;

import com.h2.example.entity.Department;

public interface DepartmentService {

	Department saveDepartment(Department department);
	
	List<Department> fetchDepartment();
	
	Department updateDepartment(Department department, Long departmentId);
	
	void deleteDepartmentById(Long departmentId);
}
