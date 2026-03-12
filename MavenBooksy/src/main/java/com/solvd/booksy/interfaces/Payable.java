package com.solvd.booksy.interfaces;

import com.solvd.booksy.enums.PaymentStatus;

public interface Payable {
    double getAmount();
    PaymentStatus getStatus();
    void processPayment();
}