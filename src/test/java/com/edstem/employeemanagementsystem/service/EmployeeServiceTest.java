package com.edstem.employeemanagementsystem.service;

import com.edstem.employeemanagementsystem.contract.EmployeeRequest;
import com.edstem.employeemanagementsystem.contract.EmployeeResponse;
import com.edstem.employeemanagementsystem.model.Employee;
import com.edstem.employeemanagementsystem.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class EmployeeServiceTest {
    @Mock
    private EmployeeRepository employeeRepository;
    @Mock
    private ModelMapper modelMapper;
    private EmployeeService employeeService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        employeeService = new EmployeeService(employeeRepository, modelMapper);

    }

    @Test
    void addEmployee() {
        EmployeeRequest request = new EmployeeRequest("name", "name@gmail.com", "department");
        Employee employee = modelMapper.map(request, Employee.class);
        EmployeeResponse ExpectedResponse = modelMapper.map(employee, EmployeeResponse.class);

        when(employeeRepository.existsByName(request.getName())).thenReturn(false);
        when(employeeRepository.save(any())).thenReturn(employee);

        EmployeeResponse actualResponse = employeeService.addEmployees(request);

        assertEquals(ExpectedResponse, actualResponse);
    }

    @Test
    void getEmployeesById() {
        Long id = 1L;
        Employee employee = new Employee(id, "name", "name@gmail.com", "department");

        EmployeeResponse expectedResponse = modelMapper.map(employee, EmployeeResponse.class);

        when(employeeRepository.findById(id)).thenReturn(Optional.of(employee));

        EmployeeResponse actualResponse = employeeService.getEmployeesById(id);

        assertEquals(expectedResponse, actualResponse);

    }

    @Test
    void getEmployeesByDepartment() {
        String query = "department";
        Employee employee1 = new Employee(1L, "name1", "name1@gmail.com", query);
        Employee employee2 = new Employee(2L, "name2", "name2@gmail", query);
        List<Employee> employees = Arrays.asList(employee1, employee2);

        List<EmployeeResponse> expectedResponse = employees.stream()
                .map(employee -> modelMapper.map(employee, EmployeeResponse.class))
                .collect(Collectors.toList());
        when(employeeRepository.searchByDepartment(query)).thenReturn(employees);

        List<EmployeeResponse> actualResponse = employeeService.getEmployeesByDepartment(query);
        assertEquals(expectedResponse, actualResponse);
    }
}
