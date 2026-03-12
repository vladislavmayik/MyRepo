package com.solvd.booksy.bookingProcess;

import com.solvd.booksy.enums.BookingStatus;
import com.solvd.booksy.interfaces.Cancelable;
import com.solvd.booksy.messages.ChatMessage;
import com.solvd.booksy.messages.Message;
import com.solvd.booksy.messages.SystemMessage;
import com.solvd.booksy.users.Client;
import com.solvd.booksy.users.Master;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Booking implements Cancelable {

    private static int totalBookingsCreated = 0;

    private final Long id;
    private Client client;
    private Master master;
    private Service service;
    private Salon salon;
    private LocalDateTime startTime;
    private BookingStatus status;
    private String comment;
    private List<Message> messages = new ArrayList<>();

    public Booking(Long id){
        this.id = id;
    }

    public Booking(Long id, Client client, Master master, Service service, Salon salon, LocalDateTime startTime, BookingStatus status, String comment) {
        this.id = id;
        this.client = client;
        this.master = master;
        this.service = service;
        this.salon = salon;
        this.startTime = startTime;
        this.status = status;
        this.comment = comment;
        totalBookingsCreated++;
    }

    public Booking(Long id, Client client, Master master, Service service, Salon salon, LocalDateTime startTime, BookingStatus status) {
        this(id, client, master, service, salon, startTime, status, null);
    }

    public Long getId() { return id; }

    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }

    public Master getMaster() { return master; }

    public void setMaster(Master master) { this.master = master; }
    public Service getService() { return service; }

    public void setService(Service service) { this.service = service; }

    public Salon getSalon() { return salon; }
    public void setSalon(Salon salon) { this.salon = salon; }

    public LocalDateTime getStartTime() { return startTime; }
    public void setStartTime(LocalDateTime startTime) { this.startTime = startTime; }

    public BookingStatus getStatus() { return status; }
    public void setStatus(BookingStatus status) { this.status = status; }

    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }

    public void addSystemMessage(String text) {
        SystemMessage msg = new SystemMessage(text);
        messages.add(msg);
        msg.printMessage(msg.getText());
    }

    public void addChatMessage(String text) {
        ChatMessage msg = new ChatMessage(text);
        messages.add(msg);
        msg.printMessage(msg.getText());
    }

    public void printAllMessages() {
        messages.forEach(msg -> msg.printMessage(msg.getText()));
    }

    @Override
    public String toString() {
        return  "Client: " + client + "\n" +
                "Master: " + master + "\n" +
                "Service: " + service + "\n" +
                "Salon: " + salon + "\n" +
                "Time: " + startTime + "\n" +
                "Status: " + status;
    }

    public static int getTotalBookingsCreated() {
        return totalBookingsCreated;
    }

    @Override
    public void cancel() {
        this.status = BookingStatus.CANCELED;
        addSystemMessage("com.solvd.booksy.models.Booking has been canceled");
    }

    @Override
    public boolean isCanceled() {
        return this.status == BookingStatus.CANCELED;
    }
}