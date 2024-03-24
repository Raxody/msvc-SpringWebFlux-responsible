package com.pragma.assets.infraestructure.persistence.mapper;


import com.pragma.assets.application.dto.ResponsibleDTO;
import com.pragma.assets.domain.entity.Responsible;
import com.pragma.assets.infraestructure.persistence.ResponsibleEntity;

public interface ResponsibleMapper {

    Responsible entityToResponsible(ResponsibleEntity responsibleEntity);

    ResponsibleEntity responsibleToEntity(Responsible responsible);

    Responsible dtoToResponsible(ResponsibleDTO responsibleDTO);

}
