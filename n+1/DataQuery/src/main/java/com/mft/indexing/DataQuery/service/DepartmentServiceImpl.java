package com.mft.indexing.DataQuery.service;

import com.mft.indexing.DataQuery.Repository.DepartmentRepository;
import com.mft.indexing.DataQuery.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl {
    @Autowired
    public DepartmentRepository departmentRepository;
    public void findAllDepartments() {
        // Implement the logic to retrieve all departments
        List<Department> departments = departmentRepository.findAllWithEmployees();

        for (Department dept : departments) {
            System.out.println(dept.getEmployees().size());
        }
    }
}
