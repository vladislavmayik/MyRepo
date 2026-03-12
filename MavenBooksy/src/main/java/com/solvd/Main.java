package com.solvd;

import com.solvd.booksy.database.AppLogger;
import com.solvd.booksy.database.CustomLinkedList;
import com.solvd.booksy.database.DataBase;
import com.solvd.booksy.database.WordCounter;
import com.solvd.booksy.enums.PaymentStatus;
import com.solvd.booksy.exceptions.InvalidBookingException;
import com.solvd.booksy.exceptions.InvalidDiscountException;
import com.solvd.booksy.exceptions.InvalidIndexException;
import com.solvd.booksy.exceptions.PaymentFailedException;
import com.solvd.booksy.bookingProcess.*;
import com.solvd.booksy.paymentProcess.Invoice;
import com.solvd.booksy.paymentProcess.Payment;
import com.solvd.booksy.paymentProcess.Promotion;
import com.solvd.booksy.records.AppointmentTime;
import com.solvd.booksy.records.Coordinates;
import com.solvd.booksy.users.Client;
import com.solvd.booksy.users.Master;
import com.solvd.booksy.users.User;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

//        Client client1 = new Client(1L, "anna@mail.com", "777135035", "Anna", "Ivanova", 0);
//        System.out.println(client1);
//
//        Master master1 = new Master(11L, "master1@gmail.com", "888123433", "John", "Smith", "Something about Myself");
//        System.out.println(master1);
//
//        DataBase.addUser(client1);
//        DataBase.addUser(master1);
//
//        Service service = new Service(111L, "Hair Cut", 30, 100.00 );
//        System.out.println(service);
//
//        Address address1 = new Address("New York","Long Street","15", "12345");
//        System.out.println(address1);
//
//        Salon salon1 = new Salon("Barbershop", "Description", address1, LocalTime.of(9, 0), LocalTime.of(21, 0));
//        System.out.println(salon1);
//
//        Booking booking1 = null;
//        try {
//            booking1 = client1.createBooking(3L, master1, service, LocalDateTime.now(), salon1);
//            System.out.println(booking1);
//        } catch (InvalidBookingException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(booking1);
//
//        master1.confirmBooking(booking1);
//        System.out.println(booking1.getStatus());
//
//        Promotion promo = new Promotion();
//        try {
//            double discounted = promo.applyDiscount(service, 150);
//        } catch (InvalidDiscountException e) {
//            e.printStackTrace();
//        }
//
//        Payment payment1 = new Payment(1111L, booking1, 100.00, PaymentStatus.PENDING);
//
//        payment1.processPayment();
//
//        Invoice invoice1 = new Invoice(11111L, payment1, LocalDateTime.now());
//        System.out.println(invoice1);
//
//        Review review1 = new Review(client1, master1, 5.0, "Great job!");
//        System.out.println(review1);
//
//        master1.completeBooking(booking1);
//        System.out.println(booking1.getStatus());
//
//        System.out.println(service.hashCode());
//        System.out.println(address1.hashCode());
//        System.out.println(payment1.hashCode());
//        System.out.println(invoice1.hashCode());
//        System.out.println(review1.hashCode());
//
//        Review review2 = new Review(client1, master1, 2.0, "Don't like it");
//        Invoice invoice2 = new Invoice(11111L, payment1, LocalDateTime.now());
//
//        System.out.println(review1.equals(review2));
//        System.out.println(address1.equals(address1));
//        System.out.println(invoice1.equals(invoice2));
//        System.out.println(service.equals(address1));
//        System.out.println(payment1.equals(payment1));
//
//        client1.sendMessage("Hello", booking1);
//        booking1.printAllMessages();
//        booking1.isCanceled();
//        booking1.cancel();
//
//        CustomLinkedList<Integer> list = new CustomLinkedList<>();
//
//        list.add(1);
//        list.add(2);
//        list.add(3);
//
//        list.printAll();
//
//        try {
//            list.insert(1,4);
//        } catch (InvalidIndexException e) {
//            throw new RuntimeException(e);
//        }
//
//        list.printAll();
//
//        list.remove(2);
//
//        list.printAll();
//
//        AppointmentTime time1 = new AppointmentTime(
//                LocalDateTime.of(2026, 1, 28, 14, 0),
//                LocalDateTime.of(2026, 1, 28, 15, 0),
//                60
//        );
//
//        Coordinates c1 = new Coordinates(56.15, 76.48);
//        System.out.println(c1.toMapLink());
//
//        System.out.println(time1.start());
//        System.out.println(time1);

        Client client1 = new Client(1L, "anna@mail.com", "777135035", "Anna", "Ivanova", 100);
        Client client2 = new Client(2L, "bob@mail.com", "777888999", "Bob", "Smith", 50);
        Client client3 = new Client(3L, "carol@mail.com", "777111222", "Carol", "Johnson", 200);
        Client client4 = new Client(4L, "dave@mail.com", "777333444", "Dave", "Brown", 30);

        DataBase.addUser(client1);
        DataBase.addUser(client2);
        DataBase.addUser(client3);
        DataBase.addUser(client4);

        List<User> allUsers = DataBase.getAllUsers();
        allUsers.stream()
                .filter(user -> user instanceof Client)
                .map(user -> (Client) user)
                .filter(client -> client.getLoyaltyPoints() > 50)
                .forEach(client -> AppLogger.info("  - " + client.getFullName() + ": " + client.getLoyaltyPoints() + " points"));

        WordCounter.count("input.txt", "output.csv");
    }
}