package com.mft.indexing.DataQuery.service;

import com.mft.indexing.DataQuery.Repository.DepartmentRepository;
import com.mft.indexing.DataQuery.dto.DepartmentResponseDto;
import com.mft.indexing.DataQuery.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartmentServiceImpl {
    @Autowired
    public DepartmentRepository departmentRepository;
@Autowired
    private RedisService redisService;
    public void findAllDepartments() {
//        // Implement the logic to retrieve all departments
//        List<Department> departments = departmentRepository.findAllWithEmployees();
////        List<Department> departments = departmentRepository.findAll();
//        for (Department dept : departments) {
//            System.out.println(dept.getEmployees().size());
//        }
    }
@Transactional
    public void findById(Long id){
        // Implement the logic to retrieve a department by ID
    DepartmentResponseDto cachedDept = redisService.getValue("department_" + id, DepartmentResponseDto.class);
    if(cachedDept != null)
    {

        System.out.println("Department found in cache: " + cachedDept.toString());
            return;
    }
    else{
        System.out.println("need to look for department with ID: " + id + " in database");
        Department department = departmentRepository.findById(id).orElse(null);

        if (department != null) {
            DepartmentResponseDto departmentResponseDto = new DepartmentResponseDto();
            departmentResponseDto.setDepartmentName(department != null ? department.getName() : null);
            departmentResponseDto.setId(department.getId());
            System.out.println("department found in database: " + department.getName() + " with ID: " + id + " and employees: " + department.getEmployees().size() + "employees");
            redisService.setValue("department_" + id, departmentResponseDto, 3600L); // Cache for 1 hour
            System.out.println("Department found: " + department.getName());
        } else {
            System.out.println("Department not found in database  with ID: " + id);
        }

    }




    }
    @Transactional
    public void deleteDepartmentByEmployeeName(String employeeName) {
        // Implement the logic to delete a department by employee name
        List<Department> departments = departmentRepository.findAll();
        for (Department dept : departments) {
            dept.getEmployees().removeIf(emp -> emp.getName().equals(employeeName));
//            departmentRepository.save(dept);
        }
    }
@Transactional
    public Department deleteDepartmentById(Long id) {

        Department department = departmentRepository.findById(id).orElse(null);
        if (department != null) {
            departmentRepository.delete(department);
            System.out.println("Department deleted: " + department.getName());
            return department;
        } else {
            System.out.println("Department not found with ID: " + id);
        }
        return null;
    }
}
