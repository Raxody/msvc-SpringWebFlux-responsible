package com.pragma.assets.application.command.handler;

import com.pragma.assets.domain.entity.Responsible;
import com.pragma.assets.domain.service.DeleteResponsibleService;
import com.pragma.assets.domain.service.GetSpecificResponsibleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class DeleteResponsibleHandler {
    private final DeleteResponsibleService deleteResponsibleService;

    public Mono<Boolean> executeDelete(String email){
        return deleteResponsibleService.executeDelete(email);
    }

}
