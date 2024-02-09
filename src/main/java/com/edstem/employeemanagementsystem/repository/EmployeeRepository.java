package com.edstem.employeemanagementsystem.repository;

import com.edstem.employeemanagementsystem.model.Employee;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> searchByDepartment(String query);

    boolean existsByName(String name);
}
