package com.hrs.booking.exception;

/**
 * The type Booking custom exception.
 */
public class BookingCustomException extends RuntimeException{

    /**
     * Instantiates a new Booking custom exception.
     */
    public BookingCustomException() {
        super();
    }

    /**
     * Instantiates a new Booking custom exception.
     *
     * @param message the message
     */
    public BookingCustomException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Booking custom exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public BookingCustomException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Booking custom exception.
     *
     * @param cause the cause
     */
    public BookingCustomException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new Booking custom exception.
     *
     * @param message            the message
     * @param cause              the cause
     * @param enableSuppression  the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    protected BookingCustomException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
