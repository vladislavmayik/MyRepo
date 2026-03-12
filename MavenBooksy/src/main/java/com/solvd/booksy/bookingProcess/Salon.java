package com.solvd.booksy.bookingProcess;

import com.solvd.booksy.users.Master;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class Salon {
    private String name;
    private String description;
    private Address address;
    private List<Master> masters;
    private LocalTime openTime;
    private LocalTime closeTime;
    private Queue<Booking> waitingList = new LinkedList<>();

    public Salon(){}

    public Salon(String name, String description, Address address, LocalTime openTime, LocalTime closeTime) {
        this.name = name;
        this.description = description;
        this.address = address;
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.masters = new ArrayList<>();
    }

    public List<Master> getMasters() {
        return masters;
    }
    public void addMaster(Master master) {
        if (!masters.contains(master)) {
            masters.add(master);
        }
    }

    public void addToWaitingList(Booking booking) {
        waitingList.add(booking);
        System.out.println("Added to waiting list: " + booking.getClient().getFullName());
    }

    public Booking processNextInWaitingList() {
        Booking next = waitingList.poll();
        if (next != null) {
            System.out.println("Processing: " + next.getClient().getFullName());
        }
        return next;
    }

    public Queue<Booking> getWaitingList() {
        return waitingList;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Address getAddress() { return address; }
    public void setAddress(Address address) { this.address = address; }

    public LocalTime getOpenTime() { return openTime; }
    public void setOpenTime(LocalTime openTime) { this.openTime = openTime; }

    public LocalTime getCloseTime() { return closeTime; }
    public void setCloseTime(LocalTime closeTime) { this.closeTime = closeTime; }

    @Override
    public String toString() {
        return name + " - " + address;
    }
}