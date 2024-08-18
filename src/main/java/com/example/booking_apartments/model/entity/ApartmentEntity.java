package com.example.booking_apartments.model.entity;

import com.example.booking_apartments.constant.RoomTypes;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "apartment")
public class ApartmentEntity {

    @Id
    @SequenceGenerator(name = "apartmentSequence", sequenceName = "apartment_sequence", allocationSize = 1, initialValue = 2)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "apartmentSequence")
    @Column(name = "id")
    private Long id;

    // entity rooms types (bedroom / living room / other spaces)
    // entity general_amenities (air  conditioning / heating / towels / washing machine / tv)

    @Column(name = "property_name")
    private String propertyName;

    @Column(name = "available")
    private boolean availability; // available or not available

    @Column(name = "price")
    private Double price; //currency?

    @Column(name = "payment_options")
    private Integer paymentOptions; // enum (cash/ card/ both)

    @Column(name = "rooms_quantity")
    private Integer roomsQuantity;

    @Column(name = "occupancy")
    private Integer occupancy; //guests Quantity;

    @Column(name = "room_type")
    @Enumerated(EnumType.STRING)
    private RoomTypes roomTypes;


    @Column(name = "free_cancellation_days")
    private Integer freeCancellationDaysBeforeArrival;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "address_entity_id")
    private AddressEntity addressEntity;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "facilities_entity_id")
    private FacilitiesEntity facilitiesEntity;


    // OneToMany???
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "image_id")
    private Image image;

   /* @OneToOne(mappedBy = "StatisticInfo")
    private StatisticInfo statisticInfo;*/
}
