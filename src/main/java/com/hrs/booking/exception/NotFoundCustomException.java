package com.hrs.booking.exception;

/**
 * The type Not found custom exception.
 */
public class NotFoundCustomException extends RuntimeException{

    /**
     * Instantiates a new Not found custom exception.
     */
    public NotFoundCustomException() {
        super();
    }

    /**
     * Instantiates a new Not found custom exception.
     *
     * @param message the message
     */
    public NotFoundCustomException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Not found custom exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public NotFoundCustomException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Not found custom exception.
     *
     * @param cause the cause
     */
    public NotFoundCustomException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new Not found custom exception.
     *
     * @param message            the message
     * @param cause              the cause
     * @param enableSuppression  the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    protected NotFoundCustomException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
