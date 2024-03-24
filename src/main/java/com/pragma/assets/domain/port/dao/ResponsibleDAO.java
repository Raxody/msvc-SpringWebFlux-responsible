package com.pragma.assets.domain.port.dao;

import com.pragma.assets.domain.entity.Responsible;
import reactor.core.publisher.Flux;

public interface ResponsibleDAO {
    Flux<Responsible> getAllAssets();

}
