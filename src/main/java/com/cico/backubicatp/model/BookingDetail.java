package com.cico.backubicatp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class BookingDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idBookingDetail;

    @Column(length = 100, nullable = false)
    private String rentalName;

    @Column(length = 150, nullable = false)
    private String address;

    @Column(length = 50, nullable = false)
    private String area;

    @Column(length = 255, nullable = false)
    private String description;

    @Column(length = 255)
    private String reference;

    @Column(length = 255)
    private String benefits;

    @ManyToOne
    @JoinColumn(name = "id_booking", nullable = false, foreignKey = @ForeignKey(name = "FK_DETAIL_BOOKING"))
    private Booking booking;
}
