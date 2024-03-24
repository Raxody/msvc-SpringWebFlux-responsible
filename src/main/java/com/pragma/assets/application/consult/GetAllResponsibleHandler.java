package com.pragma.assets.application.consult;

import com.pragma.assets.common.exception.InvalidValueException;
import com.pragma.assets.domain.entity.Responsible;
import com.pragma.assets.domain.port.dao.ResponsibleDAO;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
public class GetAllResponsibleHandler {
    private final ResponsibleDAO responsibleDAO;

    public GetAllResponsibleHandler(ResponsibleDAO assetDAO) {
        this.responsibleDAO = assetDAO;
    }

    public Flux<Responsible> execute() {
        return this.responsibleDAO.getAllAssets();
    }
}
