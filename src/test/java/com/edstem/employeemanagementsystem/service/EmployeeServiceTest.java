package com.edstem.employeemanagementsystem.service;

import com.edstem.employeemanagementsystem.model.Employee;
import com.edstem.employeemanagementsystem.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

public class EmployeeServiceTest {
    @Mock
    private EmployeeRepository employeeRepository;
    @Mock
    private ModelMapper modelMapper;
    private EmployeeService employeeService;

    @BeforeEach
public void init(){
        MockitoAnnotations.openMocks(this);
        employeeService = new EmployeeService(employeeRepository,modelMapper);

    }
    @Test
    void addEmployee(){

    }
}
