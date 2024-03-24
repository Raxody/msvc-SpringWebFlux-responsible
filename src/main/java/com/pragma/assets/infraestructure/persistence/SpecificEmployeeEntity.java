package com.pragma.assets.infraestructure.persistence;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "responsible")
@TypeAlias("SpecificEmployee")
@NoArgsConstructor
public class SpecificEmployeeEntity extends EmployeeEntity{

    private String typeOfContract;
    private String role;
    private String businessEmail;
    private Double salary;

    public SpecificEmployeeEntity(String id, String email, String fullName, String documentType, String documentNumber, CompanyEntity company, String typeOfContract, String role, String businessEmail, Double salary) {
        super(id, email, fullName, documentType, documentNumber, company);
        this.typeOfContract = typeOfContract;
        this.role = role;
        this.businessEmail = businessEmail;
        this.salary = salary;
    }
}
