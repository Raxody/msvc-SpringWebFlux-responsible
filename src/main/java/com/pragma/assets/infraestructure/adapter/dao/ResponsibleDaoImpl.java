package com.pragma.assets.infraestructure.adapter.dao;

import com.pragma.assets.domain.entity.Responsible;
import com.pragma.assets.domain.port.dao.ResponsibleDAO;
import com.pragma.assets.infraestructure.persistence.mapper.ResponsibleMapper;
import com.pragma.assets.infraestructure.crud.repository.ResponsibleCrudRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
public class ResponsibleDaoImpl implements ResponsibleDAO {
    private final ResponsibleCrudRepository responsibleCrudRepository;
    private final ResponsibleMapper responsibleMapper;

    public ResponsibleDaoImpl(ResponsibleCrudRepository responsibleCrudRepository, ResponsibleMapper responsibleMapper) {
        this.responsibleCrudRepository = responsibleCrudRepository;
        this.responsibleMapper = responsibleMapper;
    }
    @Override
    public Flux<Responsible> getAllAssets() {
        return responsibleCrudRepository.findAll().map(responsibleMapper::entityToResponsible);
    }
}
