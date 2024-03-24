package com.pragma.assets.infraestructure.router;

import com.pragma.assets.application.command.handler.GetSpecificResponsibleHandler;
import com.pragma.assets.application.consult.GetAllResponsibleHandler;
import com.pragma.assets.common.ErrorMessage;
import com.pragma.assets.domain.entity.Responsible;
import com.pragma.assets.domain.service.GetAssetsToSendSpecificFormatService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import java.util.Map;

import static com.pragma.assets.infraestructure.router.handler.GlobalExceptionHandler.serverResponseWithStatusAndObject;

@Configuration
public class ResponsibleConsultantRouter {

    private static final String EMPLOYEE = "Employee";
    private static final String FACILITIES = "Facilities";
    private static final String RESPONSIBLE = "/responsible";
    private static final String RESPONSIBLE_ID = "/responsible/byEmail/{email}";
    private static final String RESPONSIBLE_TYPE = "/responsible/byType/{type}";
    private static final String EMAIL = "email";
    private static final String TYPE = "type";
    private static final String RESPONSIBLE_SEND = "/responsible/send";

    @Bean
    public RouterFunction<ServerResponse> getAllAssets(GetAllResponsibleHandler getAllResponsibleHandler) {
        return RouterFunctions.route(
                RequestPredicates.GET(RESPONSIBLE),
                request -> {
                    try {
                        return ServerResponse.ok().body(getAllResponsibleHandler.execute(), Responsible.class);
                    } catch (Exception e) {
                        return serverResponseWithStatusAndObject(new ErrorMessage(e.getMessage(), RESPONSIBLE, e.toString()),
                                HttpStatus.BAD_REQUEST);
                    }
                }
        );
    }

    @Bean
    public RouterFunction<ServerResponse> getResponsibleByEmail(GetSpecificResponsibleHandler getSpecificResponsibleHandler) {
        return RouterFunctions.route(
                RequestPredicates.GET(RESPONSIBLE_ID),
                request -> {
                    try {
                        return ServerResponse.ok().body(getSpecificResponsibleHandler.execute(request.pathVariable(EMAIL)), Responsible.class);
                    } catch (Exception e) {
                        return serverResponseWithStatusAndObject(new ErrorMessage(e.getMessage(), RESPONSIBLE_ID, e.toString()),
                                HttpStatus.BAD_REQUEST);
                    }
                }
        );
    }

    @Bean
    public RouterFunction<ServerResponse> getResponsibleByType(GetSpecificResponsibleHandler getSpecificResponsibleHandler) {
        return RouterFunctions.route(
                RequestPredicates.GET(RESPONSIBLE_TYPE),
                request -> {
                    try {
                        return ServerResponse.ok().body(getSpecificResponsibleHandler.executeFindByType(request.pathVariable(TYPE)), Responsible.class);
                    } catch (Exception e) {
                        return serverResponseWithStatusAndObject(new ErrorMessage(e.getMessage(), RESPONSIBLE_TYPE, e.toString()),
                                HttpStatus.BAD_REQUEST);
                    }
                }
        );
    }

    @Bean
    public RouterFunction<ServerResponse> getAllEmployeeAndFacilities(GetAssetsToSendSpecificFormatService getAssetsToSendSpecificFormatService) {
        return RouterFunctions.route(
                RequestPredicates.GET(RESPONSIBLE_SEND),
                request -> {
                    try {
                        return ServerResponse.ok().body(getAssetsToSendSpecificFormatService.execute(), Map.class);
                    } catch (Exception e) {
                        return serverResponseWithStatusAndObject(new ErrorMessage(e.getMessage(), RESPONSIBLE, e.toString()),
                                HttpStatus.BAD_REQUEST);
                    }
                }
        );
    }

}