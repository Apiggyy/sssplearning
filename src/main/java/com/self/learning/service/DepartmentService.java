package com.self.learning.service;

import com.self.learning.entity.Department;
import com.self.learning.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Transactional
    public void save(Department department) {
        departmentRepository.save(department);
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.getAllDepartments();
    }
}
