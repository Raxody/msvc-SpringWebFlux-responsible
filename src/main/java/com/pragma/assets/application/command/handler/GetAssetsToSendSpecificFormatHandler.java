package com.pragma.assets.application.command.handler;

import com.pragma.assets.domain.service.GetAssetsToSendSpecificFormatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class GetAssetsToSendSpecificFormatHandler {

    private final GetAssetsToSendSpecificFormatService getAssetsToSendSpecificFormatService;

    public Flux<Map<String, Object>> executeFindEmployeeAndFacilities(){
        return getAssetsToSendSpecificFormatService.execute();
    }
}
