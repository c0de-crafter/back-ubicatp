package com.cico.backubicatp.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idBooking;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date startDate;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date endDate;

    @Column(nullable = false)
    private int numberOfPeople;

    @Column(columnDefinition = "decimal(10,2)", nullable = false)
    private float price;

    @ManyToOne
    @JoinColumn(name = "id_property", nullable = false, foreignKey = @ForeignKey(name = "FK_BOOKING_PROPERTY"))
    private Property property;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false, foreignKey = @ForeignKey(name = "FK_BOOKING_USER"))
    private User user;

    @OneToOne(mappedBy = "booking", cascade = CascadeType.ALL)
    private BookingDetail bookingDetail;
}
