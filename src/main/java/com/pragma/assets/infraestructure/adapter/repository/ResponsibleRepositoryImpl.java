package com.pragma.assets.infraestructure.adapter.repository;

import com.pragma.assets.domain.entity.Responsible;
import com.pragma.assets.domain.port.repository.ResponsibleRepository;
import com.pragma.assets.infraestructure.crud.repository.ResponsibleCrudRepository;
import com.pragma.assets.infraestructure.persistence.mapper.ResponsibleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class ResponsibleRepositoryImpl implements ResponsibleRepository {

    private final ResponsibleCrudRepository responsibleCrudRepository;
    private final ResponsibleMapper responsibleMapper;

    @Override
    public Mono<Responsible> getResponsibleByEmail(String email) {
        return responsibleCrudRepository.findByEmail(email).map(responsibleMapper::entityToResponsible);
    }

    @Override
    public Mono<Boolean> deleteResponsibleByEmail(String email) {
        return responsibleCrudRepository.deleteByEmail(email);
    }

    @Override
    public Flux<Responsible> findByClass(String type) {
        return responsibleCrudRepository.findByClass(type).map(responsibleMapper::entityToResponsible);
    }

    @Override
    public Mono<Responsible> save(Responsible responsible) {
        responsibleCrudRepository.save(responsibleMapper.responsibleToEntity(responsible)).subscribe();
        return Mono.just(responsible);
    }

    @Override
    public void update(Responsible responsible) {
        //responsibleCrudRepository.
    }
}
