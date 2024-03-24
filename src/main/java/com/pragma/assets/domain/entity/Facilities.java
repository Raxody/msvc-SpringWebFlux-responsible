package com.pragma.assets.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import static com.pragma.assets.common.util.ArgumentValidator.requireNotNull;
import static com.pragma.assets.common.util.ArgumentValidatorConstants.THE_FIELD_X_MUST_NOT_BE_EMPTY;

@Getter
@Setter
@NoArgsConstructor
public class Facilities extends Responsible {

    private static final String FIELD_NAME = "nombre";
    private static final String FIELD_CITY = "ciudad";
    private static final String FIELD_ADDRESS = "dirección";
    private String name;
    private String city;
    private String address;

    public Facilities(String id, String name, String city, String address) {
        super(id);
        requireNotNull(name, String.format(THE_FIELD_X_MUST_NOT_BE_EMPTY, FIELD_NAME));
        requireNotNull(city, String.format(THE_FIELD_X_MUST_NOT_BE_EMPTY, FIELD_CITY));
        requireNotNull(address, String.format(THE_FIELD_X_MUST_NOT_BE_EMPTY, FIELD_ADDRESS));

        this.name = name;
        this.city = city;
        this.address = address;
    }
}
