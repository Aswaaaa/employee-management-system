package com.edstem.employeemanagementsystem.contract;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeRequest {
    @NotBlank(message = "Name cannot be blank")
    private String name;
    @Email(message = "Email cannot be blank")
    private String email;
    private String department;
}
