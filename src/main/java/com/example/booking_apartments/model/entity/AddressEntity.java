package com.example.booking_apartments.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "address")
public class AddressEntity {
    @Id
    @SequenceGenerator(name="addressSequence", sequenceName="address_sequence", allocationSize = 1, initialValue = 2)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="addressSequence")
    @Column(name = "id")
    private Long id;
    @Column(name = "zip_code")
    private String zipCode;
    @Column(name = "country")
    private String country;
    @Column(name = "region")
    private String region; // or state
    @Column(name = "city")
    private String city;
    @Column(name = "street")
    private String street;
    @Column(name = "street_number")
    private String streetNumber;
    @Column(name = "apartment_number")
    private String apartmentNumber; // house/flat number
    @Column(name = "path_description")
    private String googleMapsUrl;
    @OneToOne(mappedBy = "addressEntity")
    private ApartmentEntity apartmentEntity;

}
