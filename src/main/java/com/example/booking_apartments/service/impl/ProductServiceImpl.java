package com.example.booking_apartments.service.impl;

import com.example.booking_apartments.model.entity.BookingInfoEntity;
import com.example.booking_apartments.model.entity.ProductInfoEntity;
import com.example.booking_apartments.repository.ProductInfoRepository;
import com.example.booking_apartments.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductInfoRepository productInfoRepository;

    @Override
    public ProductInfoEntity getDiscount(BookingInfoEntity bookingInfoEntity) {

        LocalDateTime startDate = bookingInfoEntity.getStartDate();
        LocalDateTime endDate = bookingInfoEntity.getEndDate();
        Double discount = 0.0;
        StringBuilder description = new StringBuilder();

        discount += getDiscountOnHolidays(startDate, endDate, description);
        discount += getDiscountByDurationOfBooking(startDate, endDate, description);
        discount += getDiscountBySeason(startDate, endDate, description);

        if (discount >= 65.0) {
            discount = 65.0;
        }

        ProductInfoEntity productInfoEntity = new ProductInfoEntity();
        productInfoEntity.setIsActive((discount != 0.0));
        productInfoEntity.setDiscountInfo(description.toString().isEmpty() ? "no discounts" : description.toString());
        productInfoEntity.setDiscount(discount);

        return productInfoRepository.save(productInfoEntity);
    }

    private Double getDiscountOnHolidays(LocalDateTime startDate, LocalDateTime endDate, StringBuilder str) {

        Double discount = 0.0;

        List<LocalDate> holidays = List.of(
                LocalDate.of(startDate.getYear(), 12, 31),
                LocalDate.of(endDate.getYear(), 1, 1),
                LocalDate.of(endDate.getYear(), 2, 23),
                LocalDate.of(endDate.getYear(), 3, 8),
                LocalDate.of(endDate.getYear(), 5, 9),
                LocalDate.of(endDate.getYear(), 6, 12),
                LocalDate.of(endDate.getYear(), 11, 4),
                LocalDate.of(endDate.getYear(), 12, 31));

        for (LocalDate holiday : holidays) {
            if (startDate.toLocalDate().isAfter(holiday) && (endDate.toLocalDate().isBefore(holiday) || endDate.toLocalDate().isEqual(holiday))) {
                discount += 10.0;
            }
        }

        if (discount != 0.0) {
            str.append("Holidays discount");
        }

        return discount;
    }

    private Double getDiscountByDurationOfBooking(LocalDateTime startDate, LocalDateTime endDate, StringBuilder str) {

        long daysOfBooking = DAYS.between(startDate, endDate);
        Double discount = 0.0;

        if (daysOfBooking >= 7) {
            str.append("Duration discount");
            discount = 7.0;
            if (daysOfBooking >= 30) {
                discount = 30.0;
            } else if (daysOfBooking >= 14) {
                discount = 15.0;
            }
        }

        return discount;
    }

    private Double getDiscountBySeason(LocalDateTime startDate, LocalDateTime endDate, StringBuilder str) {
        List<Month> seasons = List.of(Month.FEBRUARY, Month.MARCH, Month.APRIL, Month.OCTOBER, Month.NOVEMBER);
        if (seasons.contains(startDate.getMonth()) || seasons.contains(endDate.getMonth())) {
            str.append("Season discount");
            return 10.0;
        } else
            return 0.0;
    }
}
