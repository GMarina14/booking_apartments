package com.example.booking_apartments.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "image")
public class Image {

    @Id
    @SequenceGenerator(name = "imageSequence", sequenceName = "image_sequence", allocationSize = 1, initialValue = 2)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "imageSequence")
    @Column(name = "id")
    private Long id;

    @Column(name = "image")
    private byte[] image;

    // OK?
   public Image(byte[] image){
        this.image = image;
    }
}
