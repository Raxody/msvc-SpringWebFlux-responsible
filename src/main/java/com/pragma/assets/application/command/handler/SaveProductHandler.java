package com.pragma.assets.application.command.handler;

import com.pragma.assets.domain.entity.Responsible;
import com.pragma.assets.domain.service.SaveResponsibleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class SaveProductHandler {

    private final SaveResponsibleService saveResponsibleService;

    public Mono<Responsible> execute(Responsible responsible){
        return saveResponsibleService.execute(responsible);
    }

}