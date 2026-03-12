package com.solvd.booksy.bookingProcess;

import com.solvd.booksy.users.Client;
import com.solvd.booksy.users.Master;

public class Review {

    private Client client;
    private Master master;
    private Double rating;
    private String comment;

    public Review(){}

    public Review(Client client, Master master, Double rating, String comment) {
        this.client = client;
        this.master = master;
        this.rating = rating;
        this.comment = comment;
    }

    public Review(Client client, Master master, Double rating) {
        this(client, master, rating, null);
    }

    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }

    public Master getMaster() { return master; }
    public void setMaster(Master master) { this.master = master; }

    public Double getRating() { return rating; }
    public void setRating(Double rating) { this.rating = rating; }

    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }

    @Override
    public String toString() {
        return client.getFullName() + " review for " + master.getFullName() + " " + rating + " " + comment;
    }

    @Override
    public int hashCode() {
        final int config = 11;
        return config * client.hashCode() + config * master.hashCode() + config * rating.hashCode() + config * comment.hashCode() + config;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Review other = (Review) obj;
        return this.client.equals(other.client)
                && this.master.equals(other.master)
                && this.rating.equals(other.rating)
                && this.comment.equals(other.comment);
    }
}