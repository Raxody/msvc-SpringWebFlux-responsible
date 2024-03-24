package com.pragma.assets.domain.entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Responsible {

    private String id;

    public Responsible(String id) {
        this.id = id;
    }
}
