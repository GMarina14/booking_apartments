package com.example.product_apartment.repository;


import com.example.product_apartment.model.ApartmentEntity;
import com.example.product_apartment.model.BookingInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingInfoRepository extends JpaRepository<BookingInfoEntity, Long> {
    BookingInfoEntity findBookingInfoEntityById(Long id);
    List<BookingInfoEntity> findBookingInfoEntitiesByApartment(ApartmentEntity apartment);


}
