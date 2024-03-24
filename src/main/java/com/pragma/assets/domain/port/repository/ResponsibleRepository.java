package com.pragma.assets.domain.port.repository;

import com.pragma.assets.domain.entity.Responsible;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ResponsibleRepository {
    Mono<Responsible> getResponsibleByEmail(String email);

    Mono<Boolean> deleteResponsibleByEmail(String email);

    Flux<Responsible> findByClass(String className);

    Mono<Responsible> save(Responsible responsible);

    void update(Responsible responsible);

}