package com.pragma.assets.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EmployeeDTO extends ResponsibleDTO {

    private String email;
    private String fullName;
    private String documentType;
    private String documentNumber;
    @JsonProperty("company")
    private CompanyDTO companyDTO;

}
