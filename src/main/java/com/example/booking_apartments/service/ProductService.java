package com.example.booking_apartments.service;

import com.example.booking_apartments.model.entity.BookingInfoEntity;
import com.example.booking_apartments.model.entity.ProductInfoEntity;

public interface ProductService {

    public ProductInfoEntity getDiscount(BookingInfoEntity bookingInfoEntity);
}
