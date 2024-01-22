package com.hrs.booking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.hrs.booking.model.Error;

/**
 * The type Global exception handler.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handle not found exception response entity.
     *
     * @param exception the exception
     * @return the response entity
     */
    @ExceptionHandler
    public ResponseEntity<Error> handleNotFoundException(NotFoundCustomException exception) {
        return new ResponseEntity<>(new Error().errorCode(404).errorMessage(exception.getMessage()), HttpStatus.NOT_FOUND);
    }

    /**
     * Handle booking exception response entity.
     *
     * @param exception the exception
     * @return the response entity
     */
    @ExceptionHandler
    public ResponseEntity<Error> handleBookingException(BookingCustomException exception) {
        return new ResponseEntity<>(new Error().errorCode(500).errorMessage(exception.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
