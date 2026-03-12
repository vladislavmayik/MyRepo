package com.solvd.booksy.database;

import com.solvd.booksy.exceptions.BookingNotFoundException;
import com.solvd.booksy.bookingProcess.Booking;
import com.solvd.booksy.users.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class DataBase {

        private static List<Booking> allBookings = new ArrayList<>();
        private static List<User> allUsers = new ArrayList<>();

        public static void addBooking(Booking booking) {
        allBookings.add(booking);
        }

        public static List<Booking> getAllBookings() {
        return allBookings;
        }

        public static void addUser(User user) {
        allUsers.add(user);
        }

        public static List<User> getAllUsers() {
        return allUsers;
        }

        public static Booking getBookingById(Long id) {
                try {
                        for (Booking b : allBookings) {
                                if (b.getId().equals(id)) {
                                        return b;
                                }
                        }
                        throw new BookingNotFoundException("Booking with id " + id + " not found");
                } catch (BookingNotFoundException e) {
                        e.printStackTrace();
                        return null;
                }
        }
}