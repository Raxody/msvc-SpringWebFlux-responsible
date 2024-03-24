package com.pragma.assets.application.dto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class CollaboratorDTO extends EmployeeDTO {

    private String serviceDescription;
    private LocalDate endDateService;
    private Double fullPaymentService;
    private String currency;

}
