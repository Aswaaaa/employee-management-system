package com.edstem.employeemanagementsystem.contract.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class EmployeeResponse {
    private Long id;
    private String name;
    private String email;
    private String department;
}
