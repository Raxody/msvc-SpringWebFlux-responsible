package com.pragma.assets.domain.service;

import com.pragma.assets.domain.entity.Responsible;
import com.pragma.assets.domain.port.repository.ResponsibleRepository;
import reactor.core.publisher.Mono;

public class SaveResponsibleService {

    private final ResponsibleRepository responsibleRepository;

    public SaveResponsibleService(ResponsibleRepository responsibleRepository) {
        this.responsibleRepository = responsibleRepository;
    }

    public Mono<Responsible> execute(Responsible responsible) {
        return responsibleRepository.save(responsible);
    }

}
