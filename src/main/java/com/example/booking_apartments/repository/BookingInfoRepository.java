package com.example.booking_apartments.repository;

import com.example.booking_apartments.model.entity.ApartmentEntity;
import com.example.booking_apartments.model.entity.BookingInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingInfoRepository extends JpaRepository<BookingInfoEntity, Long> {


    List<BookingInfoEntity> findBookingInfoEntitiesByApartment(ApartmentEntity apartment);


}
