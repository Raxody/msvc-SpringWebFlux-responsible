package com.pragma.assets.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
public class FacilitiesDTO extends ResponsibleDTO {

    private String name;
    private String city;
    private String address;

}
