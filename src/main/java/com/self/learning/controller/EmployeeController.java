package com.self.learning.controller;

import com.self.learning.entity.Department;
import com.self.learning.entity.Employee;
import com.self.learning.service.DepartmentService;
import com.self.learning.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("")
    public String index() {
        return "emp/index";
    }

    @RequestMapping("/list")
    public String findEmployees(@RequestParam(value = "pageNo", required = false, defaultValue = "1") String pageNoStr
                                ,Model model) {
        int pageNo = 1;
        try {
            pageNo = Integer.parseInt(pageNoStr);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        if (pageNo < 1) {
            pageNo = 1;
        }
        Page<Employee> page = employeeService.findEmployees(pageNo, 5);
        model.addAttribute("page", page);
        return "emp/list";
    }

    @RequestMapping(value="/add",method = {RequestMethod.GET})
    public String addEmployee(Model model) {
        List<Department> departments = departmentService.getAllDepartments();
        model.addAttribute("departments", departments);
        model.addAttribute("employee",new Employee());
        return "emp/add";
    }
}
