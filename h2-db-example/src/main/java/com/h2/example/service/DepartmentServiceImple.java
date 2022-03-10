package com.h2.example.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h2.example.entity.Department;
import com.h2.example.repository.DepartmentRepository;

@Service
public class DepartmentServiceImple implements DepartmentService {

	@Autowired
	private DepartmentRepository repo;
	
	@Override
	public Department saveDepartment(Department department) {
		// TODO Auto-generated method stub
		return repo.save(department);
	}

	@Override
	public List<Department> fetchDepartment() {
		// TODO Auto-generated method stub
		return (List<Department>) repo.findAll();
	}

	@Override
	public Department updateDepartment(Department department, Long departmentId) {
		Department depDB
        = repo.findById(departmentId)
              .get();

    if (Objects.nonNull(department.getDepartmentName())
        && !"".equalsIgnoreCase(
            department.getDepartmentName())) {
        depDB.setDepartmentName(
            department.getDepartmentName());
    }

    if (Objects.nonNull(
            department.getDepartmentAddress())
        && !"".equalsIgnoreCase(
            department.getDepartmentAddress())) {
        depDB.setDepartmentAddress(
            department.getDepartmentAddress());
    }

    if (Objects.nonNull(department.getDepartmentCode())
        && !"".equalsIgnoreCase(
            department.getDepartmentCode())) {
        depDB.setDepartmentCode(
            department.getDepartmentCode());
    }

    return repo.save(depDB);
	}

	@Override
	public void deleteDepartmentById(Long departmentId) {
		// TODO Auto-generated method stub
		repo.deleteById(departmentId);
	}

}
