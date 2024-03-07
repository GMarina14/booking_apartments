package com.example.booking_apartments.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "integration_info")
public class IntegrationInfoEntity {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "path_value")
    private String pathValue;

    @Column(name = "key_value")
    private String keyValue;
}
