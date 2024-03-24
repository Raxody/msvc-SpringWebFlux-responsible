package com.pragma.assets.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Arrays;

import static com.pragma.assets.common.util.ArgumentValidator.*;
import static com.pragma.assets.common.util.ArgumentValidatorConstants.*;

@Getter
@Setter
@NoArgsConstructor
public class Collaborator extends Employee {

    private static final String FIELD_SERVICE_DESCRIPTION = "descripcion del servicio";
    private static final String FIELD_END_DATE_SERVICE = "fecha fin del servicio";
    private static final String FIELD_FULL_PAYMENT_SERVICE = "pago total del servicio";
    private static final String FIELD_CURRENCY = "tipo de moneda";
    private String serviceDescription;
    private LocalDate endDateService;
    private Double fullPaymentService;
    private String currency;

    public Collaborator(String id, String email, String fullName, String documentType, String documentNumber, Company company, String serviceDescription, LocalDate endDateService, Double fullPaymentService, String currency) {
        super(id, email, fullName, documentType, documentNumber, company);

        requireNotNull(serviceDescription, String.format(THE_FIELD_X_MUST_NOT_BE_EMPTY, FIELD_SERVICE_DESCRIPTION));
        requireNotNull(endDateService, String.format(THE_FIELD_X_MUST_NOT_BE_EMPTY, FIELD_END_DATE_SERVICE));
        requireNotNull(fullPaymentService, String.format(THE_FIELD_X_MUST_NOT_BE_EMPTY, FIELD_FULL_PAYMENT_SERVICE));
        requireNotNull(currency, String.format(THE_FIELD_X_MUST_NOT_BE_EMPTY, FIELD_CURRENCY));

        requireNumeric(fullPaymentService.toString(), String.format(THE_FIELD_X_MUST_BE_NUMERIC, FIELD_FULL_PAYMENT_SERVICE));

        requirePositive(fullPaymentService, String.format(THE_FIELD_X_MUST_BE_POSITIVE, FIELD_FULL_PAYMENT_SERVICE));

        allowedStates(Arrays.asList(COP, MXN, USD, EUR, JPY, CAD), currency,
                String.format(THE_CURRENCY_IS_NOT_AVAILABLE, currency));

        this.serviceDescription = serviceDescription;
        this.endDateService = endDateService;
        this.fullPaymentService = fullPaymentService;
        this.currency = currency;
    }
}
