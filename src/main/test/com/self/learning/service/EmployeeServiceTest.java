package com.self.learning.service;

import com.self.learning.entity.Department;
import com.self.learning.entity.Employee;
import com.self.learning.repository.DepartmentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext-*.xml")
public class EmployeeServiceTest {
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentRepository departmentRepository;
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Test
    public void save() throws Exception {
        Department department = new Department();
        department.setDeptName("Dept-A");
        departmentService.save(department);

        Employee employee = new Employee();
        employee.setLastName("weizhiming");
        employee.setBirth(new Date());
        employee.setEmail("360625981@qq.com");
        employee.setCreateTime(new Date());
        employee.setDept(department);
        employeeService.save(employee);
    }

    @Test
    public void findAll() {
        List<Department> departments = departmentRepository.findAll();
        departments = departmentRepository.findAll();
    }

    @Test
    public void getAll() {
        List<Department> departments = departmentRepository.getAllDepartments();
        departments = departmentRepository.getAllDepartments();
    }
}