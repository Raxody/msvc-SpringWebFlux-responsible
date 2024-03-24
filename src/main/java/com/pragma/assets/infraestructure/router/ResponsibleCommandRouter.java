package com.pragma.assets.infraestructure.router;

import com.pragma.assets.application.command.handler.DeleteResponsibleHandler;
import com.pragma.assets.application.command.handler.SaveProductHandler;
import com.pragma.assets.application.dto.ResponsibleDTO;
import com.pragma.assets.common.ErrorMessage;
import com.pragma.assets.infraestructure.persistence.mapper.ResponsibleMapper;
import com.pragma.assets.infraestructure.router.handler.GlobalExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static com.pragma.assets.infraestructure.router.handler.GlobalExceptionHandler.*;

@Configuration
public class ResponsibleCommandRouter {

    private static final String RESPONSIBLE_DELETE_EMAIL = "/responsible/delete/{email}";
    private static final String CREATE_RESPONSIBLE = "/responsible/create";
    private static final String EMAIL = "email";

    @Bean
    public RouterFunction<ServerResponse> deleteResponsibleByEmail(DeleteResponsibleHandler deleteResponsibleHandler) {
        return RouterFunctions.route(
                RequestPredicates.DELETE(RESPONSIBLE_DELETE_EMAIL),
                request -> {
                    try {
                        return ServerResponse.ok().body(deleteResponsibleHandler.executeDelete(request.pathVariable(EMAIL)),
                                Boolean.class);
                    } catch (Exception e) {
                        return serverResponseWithStatusAndObject(
                                new ErrorMessage(e.getMessage(), RESPONSIBLE_DELETE_EMAIL,
                                        e.toString()), HttpStatus.BAD_REQUEST);
                    }
                }
        );
    }

    @Bean
    public RouterFunction<ServerResponse> createResponsible(SaveProductHandler saveProductHandler, ResponsibleMapper responsibleMapper) {
        return RouterFunctions.route(
                RequestPredicates.POST(CREATE_RESPONSIBLE),
                request -> {
                    return request
                            .bodyToMono(ResponsibleDTO.class)
                            .flatMap(responsibleDTO -> {
                                saveProductHandler.execute(responsibleMapper.dtoToResponsible(responsibleDTO));

                                return serverResponseWithStatusAndObject(responsibleDTO, HttpStatus.CREATED);
                            })
                            .onErrorResume(Exception.class, e -> {
                                return serverResponseWithStatusAndObject(
                                        new ErrorMessage(e.getMessage(), CREATE_RESPONSIBLE, e.toString()), HttpStatus.CREATED);
                            });
                }
        );
    }

}
