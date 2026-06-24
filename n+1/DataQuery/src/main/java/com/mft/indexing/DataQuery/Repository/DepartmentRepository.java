package com.mft.indexing.DataQuery.Repository;

import com.mft.indexing.DataQuery.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {


    @Query("""
       SELECT d
       FROM Department d
       JOIN FETCH d.employees
       """)
    List<Department> findAllWithEmployees();

}
