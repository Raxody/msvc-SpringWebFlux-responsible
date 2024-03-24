package com.pragma.assets.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static com.pragma.assets.common.util.ArgumentValidator.requireNotNull;
import static com.pragma.assets.common.util.ArgumentValidatorConstants.THE_FIELD_X_MUST_NOT_BE_EMPTY;

@Getter
@Setter
@NoArgsConstructor
public class Company {

    private static final String FIELD_NAME = "nombre de la compañia";
    private static final String FIELD_NIT = "nit de la compañia";
    private static final String FIELD_LOCATION = "ubicación de la compañia";
    private String name;
    private String nit;
    private String location;

    public Company(String name, String nit, String location) {
        requireNotNull(name, String.format(THE_FIELD_X_MUST_NOT_BE_EMPTY, FIELD_NAME));
        requireNotNull(nit, String.format(THE_FIELD_X_MUST_NOT_BE_EMPTY, FIELD_NIT));
        requireNotNull(location, String.format(THE_FIELD_X_MUST_NOT_BE_EMPTY, FIELD_LOCATION));

        this.name = name;
        this.nit = nit;
        this.location = location;
    }
}
