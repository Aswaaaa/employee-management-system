package com.edstem.employeemanagementsystem.controller;


import com.edstem.employeemanagementsystem.contract.EmployeeRequest;
import com.edstem.employeemanagementsystem.contract.EmployeeResponse;
import com.edstem.employeemanagementsystem.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private EmployeeService employeeService;

    @Test
    void testAddEmployee() throws Exception {
        EmployeeRequest request = createEmployeeRequest();
        EmployeeResponse expectedResponse = createExpectedResponse();

        when(employeeService.addEmployees(any(EmployeeRequest.class))).thenReturn(expectedResponse);

        mockMvc.perform(post("/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(request)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(new ObjectMapper().writeValueAsString(expectedResponse)));


    }

    private EmployeeRequest createEmployeeRequest() {
        return EmployeeRequest.builder()
                .name("Test name")
                .email("test@example.com")
                .department("Test department")
                .build();
    }

    private EmployeeResponse createExpectedResponse() {
        return EmployeeResponse.builder()
                .id(2L)
                .name("Test name")
                .email("test@example.com")
                .department("Test department")
                .build();
    }



}
