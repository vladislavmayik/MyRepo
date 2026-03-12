package com.solvd.booksy.exceptions;

public class InvalidBookingException extends BookingException {
    public InvalidBookingException(String message) {
        super(message);
    }
}