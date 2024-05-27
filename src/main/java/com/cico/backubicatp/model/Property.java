package com.cico.backubicatp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idProperty;

    @Column(length = 100, nullable = false)
    private String propertyName;

    @Column(length = 255, nullable = false)
    private String description;

    @Column(length = 150, nullable = false)
    private String location;

    @Column(length = 255)
    private String benefits;

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL)
    private List<Booking> bookings;

    @ManyToOne
    @JoinColumn(name = "id_landlord", nullable = false, foreignKey = @ForeignKey(name = "FK_PROPERTY_LANDLORD"))
    private User landlord;
}
