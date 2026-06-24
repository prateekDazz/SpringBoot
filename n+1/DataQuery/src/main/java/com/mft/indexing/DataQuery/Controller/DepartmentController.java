package com.mft.indexing.DataQuery.Controller;

import com.mft.indexing.DataQuery.service.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {
    @Autowired
    private DepartmentServiceImpl departmentService;

    @GetMapping("/findAll")
    public String findAllDepartments() {
        // Implement the logic to retrieve all departments
        departmentService.findAllDepartments();
        return "Finding all departments";
    }
}
