package com.cico.backubicatp.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PropertyDTO {

    private Integer idProperty;

    @NotNull
    @Size(min = 3, max = 100)
    private String propertyName;

    @NotNull
    @Size(min = 3, max = 255)
    private String description;

    @NotNull
    @Size(min = 3, max = 150)
    private String location;

    @Size(max = 255)
    private String benefits;

    @NotNull
    private UserDTO landlord;

    @Size(max = 50)
    private String reviews;

    @Size(max = 255)
    private String image;

    @NotNull
    private Double price;
}
