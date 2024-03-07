package com.example.booking_apartments.repository;

import com.example.booking_apartments.model.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {

    Image findImageById(Long id);
}
