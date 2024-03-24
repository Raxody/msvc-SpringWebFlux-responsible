package com.pragma.assets.domain.service;

import com.pragma.assets.domain.entity.Responsible;
import com.pragma.assets.domain.port.repository.ResponsibleRepository;
import reactor.core.publisher.Mono;

public class UpdateResponsibleService {

    private final ResponsibleRepository responsibleRepository;

    public UpdateResponsibleService(ResponsibleRepository responsibleRepository) {
        this.responsibleRepository = responsibleRepository;
    }

    public void execute(Responsible responsible) {
        responsibleRepository.update(responsible);
    }

}
