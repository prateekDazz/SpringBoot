package com.mft.indexing.DataQuery.service;

import com.mft.indexing.DataQuery.Repository.EmployeeRepository;
import com.mft.indexing.DataQuery.dto.EmployeeResponseDto;
import com.mft.indexing.DataQuery.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataQueryServiceImpl {

    @Autowired
    private EmployeeRepository repository;

    public EmployeeResponseDto getByEmail(String email) {
        Employee employee =  repository.findByEmail(email)
                .orElseThrow();

        return EmployeeResponseDto.builder()
                .name(employee.getName())
                .email(employee.getEmail())
                .department(employee.getDepartment())
                .salary(employee.getSalary())
                .build();

    }

    public List<EmployeeResponseDto>findAllEmails(){
        List<Employee> employees = repository.findAll();
        return employees.stream().map(employee -> EmployeeResponseDto.builder()
                .name(employee.getName())
                .email(employee.getEmail())
                .department(employee.getDepartment())
                .salary(employee.getSalary())
                .build()).toList();
    }
}
