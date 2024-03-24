package com.pragma.assets.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SpecificEmployeeDTO extends EmployeeDTO {

    private String typeOfContract;
    private String role;
    private String businessEmail;
    private Double salary;

}
