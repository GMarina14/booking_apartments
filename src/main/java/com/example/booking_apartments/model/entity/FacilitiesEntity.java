package com.example.booking_apartments.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "facilities")
public class FacilitiesEntity {

    @Id
    @SequenceGenerator(name = "facilitiesSequence", sequenceName = "facilities_sequence", allocationSize = 1, initialValue = 2)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "facilitiesSequence")
    @Column(name = "id")
    private Long id;

    @Column(name = "wi_fi")
    private boolean wiFi;

    @Column(name = "parking")
    private boolean parking;
    @Column(name = "air_conditioning")
    private boolean airConditioning;
    @Column(name = "housekeeping")
    private boolean housekeeping;
    @Column(name = "terrace")
    private boolean terrace;
    @Column(name = "garden")
    private boolean garden;
    @Column(name = "beach")
    private boolean beach;
    @Column(name = "heating")
    private boolean heating;
    @Column(name = "swimming_pool")
    private boolean swimmingPool;
    @Column(name = "bar")
    private boolean bar;
    @OneToOne(mappedBy = "facilitiesEntity")
    private ApartmentEntity apartmentEntity;


}
