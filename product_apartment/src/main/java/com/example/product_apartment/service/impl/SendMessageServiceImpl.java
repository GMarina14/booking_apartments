package com.example.product_apartment.service.impl;


import com.example.product_apartment.emailSender.EmailSender;
import com.example.product_apartment.model.BookingInfoEntity;
import com.example.product_apartment.model.UserRegistrationFormEntity;
import com.example.product_apartment.repository.BookingInfoRepository;
import com.example.product_apartment.repository.UserRegistrationRepository;
import com.example.product_apartment.service.SendMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.example.product_apartment.constant.ProductConstant.BOOKING_HAS_FAILED;
import static com.example.product_apartment.constant.ProductConstant.BOOKING_IS_SUCCESSFUL;
import static java.util.Objects.isNull;

@Service
@RequiredArgsConstructor
public class SendMessageServiceImpl implements SendMessageService {

    private final EmailSender emailSender;
    private final UserRegistrationRepository userRegistrationRepository;
    private final BookingInfoRepository bookingInfoRepository;

    /**
     * The method sends message to the user about his booking.
     * the message also contains info about discounts the user gets
     *
     * @param bookingId
     */

    @Override
    public void sendMessage(Long bookingId) {

        BookingInfoEntity bookingInfoEntity = bookingInfoRepository.findBookingInfoEntityById(bookingId);
        UserRegistrationFormEntity user = bookingInfoEntity.getUser();

        emailSender.sendEmail(createSubject(bookingInfoEntity), createMessage(bookingInfoEntity, user), user.getUsername());
    }

    /**
     * Depending on booking status the method creates a subject of the message
     *
     * @param bookingInfo
     * @return
     */
    private String createSubject(BookingInfoEntity bookingInfo) {
        return (isNull(bookingInfo) ? BOOKING_HAS_FAILED : BOOKING_IS_SUCCESSFUL);
    }

    /**
     * The method creates message templates
     * if the booking is unsuccessful, the method informs about it and vice versa
     *
     * @param bookingInfo
     * @param user
     * @return
     */
    private String createMessage(BookingInfoEntity bookingInfo, UserRegistrationFormEntity user) {
        String text;

        if (isNull(bookingInfo)) {
            text = "Dear, " + user.getNickname() + "!\n Unfortunately something went wrong and your booking has not been completed. " +
                    "More details will be sent to you withing 24 hours." +
                    " We are very sorry.\n With best regards Team Booking Apartments";
        } else {
            text = "Dear, " + user.getNickname() + "!\n We are happy to inform you, that your booking for " + bookingInfo.getApartment().getPropertyName() +
                    " during " + bookingInfo.getStartDate() + "-" + bookingInfo.getEndDate() + " is successful! \n" +
                    "Your  personal discount is " + bookingInfo.getDiscount() + " and final price is " + bookingInfo.getPrice() +
                    ".\n Thank you for choosing our services and we hope you enjoy your stay at " + bookingInfo.getApartment().getPropertyName() +
                    "\n With best regards Team Booking Apartments";
        }
        return text;
    }
}
