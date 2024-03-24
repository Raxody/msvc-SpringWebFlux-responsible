package com.pragma.assets.application.command.handler;

import com.pragma.assets.domain.entity.Responsible;
import com.pragma.assets.domain.service.GetSpecificResponsibleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class GetSpecificResponsibleHandler {

    private final GetSpecificResponsibleService getSpecificResponsibleService;

    public Mono<Responsible> execute(String email){
        return getSpecificResponsibleService.execute(email);
    }

    public Flux<Responsible> executeFindByType(String type){
        return getSpecificResponsibleService.executeFindByType(type);
    }

}
