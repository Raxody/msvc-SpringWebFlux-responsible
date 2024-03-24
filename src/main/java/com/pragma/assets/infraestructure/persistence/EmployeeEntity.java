package com.pragma.assets.infraestructure.persistence;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "responsible")
@TypeAlias("Employee")
@NoArgsConstructor
public class EmployeeEntity extends ResponsibleEntity {

    private String email;
    private String fullName;
    private String documentType;
    private String documentNumber;
    private CompanyEntity company;

    public EmployeeEntity(String id, String email, String fullName, String documentType, String documentNumber, CompanyEntity company) {
        super(id);
        this.email = email;
        this.fullName = fullName;
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.company = company;
    }
}
