package com.hrs.booking.controller;

import com.hrs.booking.model.Booking;
import com.hrs.booking.model.Delete;
import com.hrs.booking.service.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The type Booking controller.
 */
@RestController
@AllArgsConstructor
@Validated
public class BookingController implements com.hrs.booking.api.BookingApi {
    private BookingService bookingService;

    @Override
    public ResponseEntity<Delete> cancelHotelBooking(Long bookingId) {
        bookingService.cancelBooking(bookingId);
        return new ResponseEntity<>(new Delete().id(bookingId).message("Booking Cancelled"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Booking>> createUserBooking(Long userId, List<Booking> booking) {
        return new ResponseEntity<>(bookingService.createBooking(userId, booking), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Booking> getBookingById(Long bookingId) {
        return new ResponseEntity<>(bookingService.getBookingById(bookingId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Booking>> getBookingByUserId(Long userId) {

        return new ResponseEntity<>(bookingService.getBookingByUserId(userId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Booking> updateBookingDetails(Long bookingId, Booking booking) {
        return new ResponseEntity<>(bookingService.updateBooking(bookingId, booking), HttpStatus.OK);
    }
}
