package com.mft.indexing.DataQuery.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(
        name = "employee",
        indexes = {
                @Index(name = "idx_email", columnList = "email"),
                @Index(name = "idx_department_salary",
                        columnList = "department,salary")
        }
)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String department;

    private Double salary;
}
