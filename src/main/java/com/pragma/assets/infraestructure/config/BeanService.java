package com.pragma.assets.infraestructure.config;

import com.pragma.assets.domain.port.dao.ResponsibleDAO;
import com.pragma.assets.domain.port.repository.ResponsibleRepository;
import com.pragma.assets.domain.service.DeleteResponsibleService;
import com.pragma.assets.domain.service.GetAssetsToSendSpecificFormatService;
import com.pragma.assets.domain.service.GetSpecificResponsibleService;
import com.pragma.assets.domain.service.SaveResponsibleService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanService {

    @Bean
    public DeleteResponsibleService deleteResponsibleService(ResponsibleRepository responsibleRepository){
        return new DeleteResponsibleService(responsibleRepository);
    }

    @Bean
    public GetSpecificResponsibleService getSpecificResponsibleService(ResponsibleRepository responsibleRepository){
        return new GetSpecificResponsibleService(responsibleRepository);
    }

    @Bean
    public SaveResponsibleService saveResponsibleService(ResponsibleRepository responsibleRepository){
        return new SaveResponsibleService(responsibleRepository);
    }

    @Bean
    public GetAssetsToSendSpecificFormatService getAssetsToSendSpecificFormatService(ResponsibleDAO responsibleDAO){
        return new GetAssetsToSendSpecificFormatService(responsibleDAO);
    }
}
