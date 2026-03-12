package com.solvd.booksy.paymentProcess;

import com.solvd.booksy.enums.PaymentStatus;
import com.solvd.booksy.interfaces.Payable;
import com.solvd.booksy.bookingProcess.Booking;

public class Payment implements Payable {

    private final Long id;
    private Booking booking;
    private Double amount;
    private PaymentStatus status;

    public Payment(Long id) {
        this.id = id;
    }

    public Payment(Long id, Booking booking, Double amount, PaymentStatus status) {
        this.id = id;
        this.booking = booking;
        this.amount = amount;
        this.status = status;
    }

    public Long getId() {
        return id;
    }
    //public void setId(Long id) { this.id = id; }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    @Override
    public double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Total payed: " + amount + " status: " + status;
    }

    @Override
    public int hashCode() {
        final int config = 7;
        return config * id.hashCode() + config * booking.hashCode() + config * amount.hashCode() + config * status.hashCode() + config;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Payment other = (Payment) obj;
        return this.id.equals(other.id)
                && this.booking.equals(other.booking)
                && this.amount.equals(other.amount)
                && this.status.equals(other.status);
    }

    @Override
    public void processPayment() {
        this.status = PaymentStatus.PAID;
        System.out.println("com.solvd.booksy.paymentProcess.Payment processed: " + amount);
    }
}