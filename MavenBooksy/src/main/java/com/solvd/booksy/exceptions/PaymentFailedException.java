package com.solvd.booksy.exceptions;

public class PaymentFailedException extends BookingException {
    public PaymentFailedException(String message) {
        super(message);
    }
}