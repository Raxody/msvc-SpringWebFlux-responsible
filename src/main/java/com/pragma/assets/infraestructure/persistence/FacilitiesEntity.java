package com.pragma.assets.infraestructure.persistence;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "responsible")
@TypeAlias("Facilities")
@NoArgsConstructor
public class FacilitiesEntity extends ResponsibleEntity{

    private String name;
    private String city;
    private String address;

    public FacilitiesEntity(String id, String name, String city, String address) {
        super(id);
        this.name = name;
        this.city = city;
        this.address = address;
    }
}
