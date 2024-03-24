package com.pragma.assets.domain.service;

import com.pragma.assets.domain.entity.*;
import com.pragma.assets.domain.port.dao.ResponsibleDAO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

public class GetAssetsToSendSpecificFormatService {

    private static final String ID = "ID";
    private static final String EMAIL = "email";
    private static final String NAME = "name";
    private static final String NAME_COMPANY = "nameCompany";
    private static final String CITY = "city";

    private final ResponsibleDAO responsibleDAO;

    public GetAssetsToSendSpecificFormatService(ResponsibleDAO responsibleDAO) {
        this.responsibleDAO = responsibleDAO;
    }

    public Flux<Map<String, Object>> execute() {
        return responsibleDAO.getAllAssets()
                .flatMap(this::mapResponsibleToMap);
    }

    private Mono<Map<String, Object>> mapResponsibleToMap(Responsible responsible) {
        Map<String, Object> resultMap = new HashMap<>();

        if (responsible instanceof SpecificEmployee specificEmployee) {
            resultMap.put(ID, specificEmployee.getId());
            resultMap.put(EMAIL, specificEmployee.getEmail());
            resultMap.put(NAME, specificEmployee.getFullName());
            resultMap.put(NAME_COMPANY, specificEmployee.getCompany().getName());
        } else if (responsible instanceof Collaborator collaborator) {
            resultMap.put(ID, collaborator.getId());
            resultMap.put(EMAIL, collaborator.getEmail());
            resultMap.put(NAME, collaborator.getFullName());
            resultMap.put(NAME_COMPANY, collaborator.getCompany().getName());
        } else if (responsible instanceof Employee employee) {
            resultMap.put(ID, employee.getId());
            resultMap.put(EMAIL, employee.getEmail());
            resultMap.put(NAME, employee.getFullName());
            resultMap.put(NAME_COMPANY, employee.getCompany().getName());
        } else if (responsible instanceof Facilities facilities) {
            resultMap.put(ID, facilities.getId());
            resultMap.put(NAME, facilities.getName());
            resultMap.put(CITY, facilities.getCity());
        }
        return Mono.just(resultMap);
    }
}
