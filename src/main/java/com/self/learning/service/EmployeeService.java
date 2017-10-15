package com.self.learning.service;

import com.self.learning.entity.Employee;
import com.self.learning.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Transactional(readOnly = true)
    public Page<Employee> findEmployees(int pageNo, int pageSize) {
        Pageable pageable = new PageRequest(pageNo - 1, pageSize);
        return employeeRepository.findAll(pageable);
    }
}
