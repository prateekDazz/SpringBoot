package com.mft.indexing.DataQuery.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(
        name = "employee"
)
public class Employee {

    @Id
    private Long id;

    private String name;

    @ManyToOne
    private Department department;
}
