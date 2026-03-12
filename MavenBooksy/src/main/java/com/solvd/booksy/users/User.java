package com.solvd.booksy.users;

import com.solvd.booksy.bookingProcess.Booking;

import java.util.List;

public abstract class User {

    private Long id;
    private String email;
    private String phone;
    private String firstName;
    private String lastName;

    public User(){}

    public User(Long id, String email, String phone, String firstName, String lastName) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public abstract void sendMessage(String text, Booking booking);

    public abstract List<Booking> getBookings();

    public final String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public String toString() {
        return getFullName() + " (" + email + ")";
    }
}