package com.pragma.assets.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Arrays;

import static com.pragma.assets.common.util.ArgumentValidator.*;
import static com.pragma.assets.common.util.ArgumentValidator.allowedStates;
import static com.pragma.assets.common.util.ArgumentValidatorConstants.*;
import static com.pragma.assets.common.util.ArgumentValidatorConstants.THE_CURRENCY_IS_NOT_AVAILABLE;

@Getter
@Setter
@NoArgsConstructor
public class SpecificEmployee extends Employee{

    private static final String FIELD_TYPE_OF_CONTRACT = "tipo de contrato";
    private static final String FIELD_ROLE = "rol";
    private static final String FIELD_BUSINESS_EMAIL = "correo electronico de la compañia";
    private static final String FIELD_SALARY = "salario";
    private String typeOfContract;
    private String role;
    private String businessEmail;
    private Double salary;

    public SpecificEmployee(String id, String email, String fullName, String documentType, String documentNumber, Company company, String typeOfContract, String role, String businessEmail, Double salary) {
        super(id, email, fullName, documentType, documentNumber, company);
        requireNotNull(typeOfContract, String.format(THE_FIELD_X_MUST_NOT_BE_EMPTY, FIELD_TYPE_OF_CONTRACT));
        requireNotNull(role, String.format(THE_FIELD_X_MUST_NOT_BE_EMPTY, FIELD_ROLE));
        requireNotNull(businessEmail, String.format(THE_FIELD_X_MUST_NOT_BE_EMPTY, FIELD_BUSINESS_EMAIL));
        requireNotNull(salary, String.format(THE_FIELD_X_MUST_NOT_BE_EMPTY, FIELD_SALARY));

        requireNumeric(salary.toString(), String.format(THE_FIELD_X_MUST_BE_NUMERIC, FIELD_SALARY));

        requirePositive(salary, String.format(THE_FIELD_X_MUST_BE_POSITIVE, FIELD_SALARY));

        allowedStates(Arrays.asList(UNDEFINED, FIXED_TERM, PROVISION_OF_SERVICES, LABOR_HOUR,PRACTICES), typeOfContract,
                String.format(THE_TYPE_OF_CONTRACT_IS_NOT_AVAILABLE, typeOfContract));


        this.typeOfContract = typeOfContract;
        this.role = role;
        this.businessEmail = businessEmail;
        this.salary = salary;
    }
}
