package com.edstem.employeemanagementsystem.controller;

import com.edstem.employeemanagementsystem.contract.EmployeeRequest;
import com.edstem.employeemanagementsystem.contract.EmployeeResponse;
import com.edstem.employeemanagementsystem.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/employees")
    public EmployeeResponse addEmployees(@Valid @RequestBody  EmployeeRequest request){
        return employeeService.addEmployees(request);
    }
    @GetMapping("/employees/{id}")
    public EmployeeResponse getEmployeesById(@PathVariable Long id){
        return employeeService.getEmployeesById(id);

    }
     @GetMapping("/employees")
    public List<EmployeeResponse> getEmployeesByDepartment(@RequestParam("department") String query){
        return employeeService.getEmployeesByDepartment(query);
     }



}
