package com.cico.backubicatp.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookingDTO {

    private Integer idBooking;

    @NotNull
    private Date startDate;

    @NotNull
    private Date endDate;

    @NotNull
    @Min(value = 1)
    private int numberOfPeople;

    @NotNull
    @Min(value = 0)
    private float price;

    @NotNull
    private PropertyDTO property;

    @NotNull
    private UserDTO user;

    @NotNull
    private List<BookingDetailDTO> bookingDetails;
}
