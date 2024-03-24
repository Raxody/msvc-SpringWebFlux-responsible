package com.pragma.assets.infraestructure.router.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

public final class GlobalExceptionHandler {

    public static Mono<ServerResponse> serverResponseWithStatusAndObject(Object object, HttpStatus httpStatus) {
        return ServerResponse.status(httpStatus)
                .contentType(org.springframework.http.MediaType.APPLICATION_JSON)
                .bodyValue(object);
    }

}
