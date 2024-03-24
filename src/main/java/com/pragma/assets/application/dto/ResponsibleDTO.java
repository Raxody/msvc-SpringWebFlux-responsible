package com.pragma.assets.application.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = EmployeeDTO.class, name = "Employee"),
        @JsonSubTypes.Type(value = FacilitiesDTO.class, name = "Facilities"),
        @JsonSubTypes.Type(value = SpecificEmployeeDTO.class, name = "SpecificEmployee"),
        @JsonSubTypes.Type(value = CollaboratorDTO.class, name = "Collaborator")
})
@NoArgsConstructor
public class ResponsibleDTO {

    private String id;
}
