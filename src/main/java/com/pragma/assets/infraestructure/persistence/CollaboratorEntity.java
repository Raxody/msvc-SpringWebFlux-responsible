package com.pragma.assets.infraestructure.persistence;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Getter
@Setter
@Document(collection = "responsible")
@TypeAlias("Collaborator")
@NoArgsConstructor
public class CollaboratorEntity extends EmployeeEntity {

    private String serviceDescription;
    private LocalDate endDateService;
    private Double fullPaymentService;
    private String currency;

    public CollaboratorEntity(String id, String email, String fullName, String documentType, String documentNumber, CompanyEntity company, String serviceDescription, LocalDate endDateService, Double fullPaymentService, String currency) {
        super(id, email, fullName, documentType, documentNumber, company);
        this.serviceDescription = serviceDescription;
        this.endDateService = endDateService;
        this.fullPaymentService = fullPaymentService;
        this.currency = currency;
    }
}
