package com.pragma.assets.domain.entity;

import com.pragma.assets.common.util.ArgumentValidatorConstants;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Arrays;

import static com.pragma.assets.common.util.ArgumentValidator.allowedStates;
import static com.pragma.assets.common.util.ArgumentValidator.requireNotNull;
import static com.pragma.assets.common.util.ArgumentValidatorConstants.*;

@Getter
@Setter
@NoArgsConstructor
public class Employee extends Responsible {


    private static final String FIELD_EMAIL = "correo electronico";
    private static final String FIELD_FULL_NAME = "nombre completo";
    private static final String FIELD_DOCUMENT_TYPE = "tipo de documento";
    private static final String FIELD_DOCUMENT_NUMBER = "numero de documento";
    private String email;
    private String fullName;
    private String documentType;
    private String documentNumber;
    private Company company;


    public Employee(String id, String email, String fullName, String documentType, String documentNumber, Company company) {
        super(id);
        requireNotNull(email, String.format(THE_FIELD_X_MUST_NOT_BE_EMPTY, FIELD_EMAIL));
        requireNotNull(fullName, String.format(THE_FIELD_X_MUST_NOT_BE_EMPTY, FIELD_FULL_NAME));
        requireNotNull(documentType, String.format(THE_FIELD_X_MUST_NOT_BE_EMPTY, FIELD_DOCUMENT_TYPE));
        requireNotNull(documentNumber, String.format(THE_FIELD_X_MUST_NOT_BE_EMPTY, FIELD_DOCUMENT_NUMBER));

        allowedStates(Arrays.asList(CITIZENSHIP_CARD, FOREIGNER_ID, PASSPORT, IDENTITY_CARD), documentType,
                String.format(THE_TYPE_OF_IDENTITY_IS_NOT_AVAILABLE, documentType));

        this.email = email;
        this.fullName = fullName;
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.company = company;
    }
}
