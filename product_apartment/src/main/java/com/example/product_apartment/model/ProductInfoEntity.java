package com.example.product_apartment.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product_info")
public class ProductInfoEntity {

    @Id
    @SequenceGenerator(name = "product_infoSequence", sequenceName = "product_info_sequence", allocationSize = 1, initialValue = 2)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_infoSequence")
    @Column(name = "id")
    private Long id;

    @Column(name="is_active")
    private Boolean isActive;

    @Column(name="discount_info")
    private String discountInfo;

    @Column(name="discount")
    private Double discount;
}

