package com.solvd.booksy.users;

import com.solvd.booksy.database.DataBase;
import com.solvd.booksy.enums.BookingStatus;
import com.solvd.booksy.enums.PaymentStatus;
import com.solvd.booksy.exceptions.InvalidBookingException;
import com.solvd.booksy.exceptions.PaymentFailedException;
import com.solvd.booksy.bookingProcess.Booking;
import com.solvd.booksy.paymentProcess.Payment;
import com.solvd.booksy.bookingProcess.Salon;
import com.solvd.booksy.bookingProcess.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Client extends User {

    private Integer loyaltyPoints;

    public Client(){}

    public Client(Long id, String email, String phone, String firstName, String lastName, Integer loyaltyPoints) {
        super(id, email, phone, firstName, lastName);
        this.loyaltyPoints = loyaltyPoints;
    }

    public Integer getLoyaltyPoints() { return loyaltyPoints; }
    public void setLoyaltyPoints(Integer loyaltyPoints) { this.loyaltyPoints = loyaltyPoints; }

    public Booking createBooking(Long bookingId, Master master, Service service, LocalDateTime startTime, Salon salon) throws InvalidBookingException {
        if (master == null || service == null) {
            throw new InvalidBookingException("Master and Service cannot be null");
        }
        Booking booking = new Booking(bookingId, this, master, service, salon, startTime, BookingStatus.CREATED);
        DataBase.addBooking(booking);
        return booking;
    }

    public void cancelBooking(Booking booking) {
        booking.setStatus(BookingStatus.CANCELED);
    }

    public void payBooking(Booking booking, Payment payment, String cardNumber) throws PaymentFailedException {
        try {
            if (cardNumber == null || cardNumber.length() < 16) {
                throw new PaymentFailedException("Invalid card number");
            }
            payment.setStatus(PaymentStatus.PAID);
            booking.addSystemMessage("Total of " + payment.getAmount() + " paid by Card N: " + cardNumber);
        } catch (PaymentFailedException e) {
            e.printStackTrace();
        }
    }

    public void payBooking(Booking booking, Payment payment, double cashAmount) {
        payment.setStatus(PaymentStatus.PAID);
        booking.addSystemMessage("Total of " + payment.getAmount() + "payed by cash");
    }

    public void payBooking(Booking booking, Payment payment, int loyaltyPoints) {
        payment.setStatus(PaymentStatus.PAID);
        booking.addSystemMessage("Total of: " + payment.getAmount() + " payed by Loyalty Points (" + loyaltyPoints + ")");
    }

    @Override
    public List<Booking> getBookings() {
        List<Booking> clientBookings = new ArrayList<>();
        for (Booking b : DataBase.getAllBookings()) {
            if (b.getClient().equals(this)) {
                clientBookings.add(b);
                System.out.println(clientBookings);
            }
        }
        return clientBookings;
    }

    @Override
    public void sendMessage(String text, Booking booking) {
        booking.addChatMessage(text);
    }
}