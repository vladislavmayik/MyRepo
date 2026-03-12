package com.solvd.booksy.users;

import com.solvd.booksy.database.DataBase;
import com.solvd.booksy.enums.BookingStatus;
import com.solvd.booksy.exceptions.InvalidBookingException;
import com.solvd.booksy.messages.ChatMessage;
import com.solvd.booksy.bookingProcess.Address;
import com.solvd.booksy.bookingProcess.Booking;
import com.solvd.booksy.bookingProcess.Salon;
import com.solvd.booksy.bookingProcess.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Master extends User {

    private String bio;
    private Double rating;
    private Salon salon;
    private Set<Service> services = new HashSet<>();

    public Master(){}

    public Master(Long id, String email, String phone, String firstName, String lastName, String bio) {
        super(id, email, phone,  firstName, lastName);
        this.bio = bio;
        this.rating = null;
    }

    public String getBio() { return bio; }
    public void setBio(String bio) { this.bio = bio; }

    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }

    public Salon getSalon() { return salon; }
    public void createSalon(String name, String description, Address address, LocalTime openTime, LocalTime closeTime) {
        Salon salon = new Salon(name, description, address, openTime, closeTime);
        salon.addMaster(this);
        this.salon = salon;
    }

    public Set<Service> getServices() {
        return services;
    }

    public void addService(Service service) {
        services.add(service);
    }

    public void confirmBooking(Booking booking) {
        try {
            if (booking == null) {
                throw new InvalidBookingException("Booking cannot be null");
            }
            if (booking.getStatus() == BookingStatus.CANCELED) {
                throw new InvalidBookingException("Cannot confirm a canceled booking");
            }
            booking.setStatus(BookingStatus.CONFIRMED);
            booking.addSystemMessage("Your booking has been confirmed!");
        } catch (InvalidBookingException e) {
            e.printStackTrace();
        }
    }

    public void completeBooking(Booking booking) {
        booking.setStatus(BookingStatus.COMPLETED);
        booking.addSystemMessage("Your booking is completed");
    }

    @Override
    public void sendMessage(String text, Booking booking) {
        ChatMessage msg = new ChatMessage(text);
        booking.addChatMessage(msg.getText());
    }

    @Override
    public List<Booking> getBookings() {
        List<Booking> masterBookings = new ArrayList<>();
        for (Booking b : DataBase.getAllBookings()) {
            if (b.getMaster().equals(this)) {
                masterBookings.add(b);
            }
        }
        return masterBookings;
    }
}