package com.pragma.assets.infraestructure.persistence;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "responsible")
public class ResponsibleEntity {

    @Id
    private String id;

    public ResponsibleEntity(String id) {
        this.id = id;
    }
}
