package com.pragma.assets.domain.service;

import com.pragma.assets.domain.entity.*;
import com.pragma.assets.domain.port.repository.ResponsibleRepository;
import com.pragma.assets.infraestructure.persistence.CollaboratorEntity;
import com.pragma.assets.infraestructure.persistence.EmployeeEntity;
import com.pragma.assets.infraestructure.persistence.FacilitiesEntity;
import com.pragma.assets.infraestructure.persistence.SpecificEmployeeEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetSpecificResponsibleService {
    private final ResponsibleRepository responsibleRepository;

    public GetSpecificResponsibleService(ResponsibleRepository responsibleRepository) {
        this.responsibleRepository = responsibleRepository;
    }

    public Mono<Responsible> execute(String email) {
        return responsibleRepository.getResponsibleByEmail(email);
    }

    public Flux<Responsible> executeFindByType(String type) {
        return responsibleRepository.findByClass(type);
    }



}
