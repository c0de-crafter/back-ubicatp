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
public class BookingDetailDTO {

    private Integer idBookingDetail;

    @NotNull
    @Size(min = 3, max = 100)
    private String rentalName;

    @NotNull
    @Size(min = 3, max = 150)
    private String address;

    @NotNull
    @Size(min = 2, max = 50)
    private String area;

    @NotNull
    @Size(min = 3, max = 255)
    private String description;

    @Size(max = 255)
    private String reference;

    @Size(max = 255)
    private String benefits;

    @NotNull
    private BookingDTO booking;
}
