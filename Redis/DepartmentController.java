package com.mft.indexing.DataQuery.Controller;

import com.mft.indexing.DataQuery.model.Department;
import com.mft.indexing.DataQuery.service.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/findById")
    public String findDepartmentById(@RequestParam Long id) {
        // Implement the logic to retrieve a department by ID
        departmentService.findById(id);
        return "Finding department by ID";
    }
    @DeleteMapping("/deleteByEmployeeName")
    public String deleteDepartmentByEmployeeName(@RequestParam String employeeName) {
        // Implement the logic to delete a department by employee name
        departmentService.deleteDepartmentByEmployeeName(employeeName);
        return "Deleting department by employee name";
    }
    @DeleteMapping("/deleteById")
    public ResponseEntity<Department> deleteDepartmentById(@RequestParam Long id) {
        // Implement the logic to delete a department by ID
        Department department = departmentService.deleteDepartmentById(id);
        return ResponseEntity.ok(department);
    }
}
