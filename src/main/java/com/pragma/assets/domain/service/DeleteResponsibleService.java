package com.pragma.assets.domain.service;

import com.pragma.assets.domain.entity.Responsible;
import com.pragma.assets.domain.port.repository.ResponsibleRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
public class DeleteResponsibleService {
    private final ResponsibleRepository responsibleRepository;

    public DeleteResponsibleService(ResponsibleRepository responsibleRepository) {
        this.responsibleRepository = responsibleRepository;
    }

    public Mono<Boolean> executeDelete(String email) {
        return responsibleRepository.getResponsibleByEmail(email)
                .flatMap(existingResponsible -> {
                    if (existingResponsible != null) {
                        return responsibleRepository.deleteResponsibleByEmail(email)
                                .then(Mono.just(true));
                    } else {
                        return Mono.just(false);
                    }
                })
                .defaultIfEmpty(false);
    }


}
