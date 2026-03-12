package com.solvd.booksy.bookingProcess;

import com.solvd.booksy.interfaces.Discountable;

public class Service implements Discountable {

    private final Long id;
    private String name;
    private Integer durationMinutes;
    private Double price;

    public Service(Long id){
        this.id = id;
    }

    public Service(Long id, String name, Integer durationMinutes, Double price) {
        this.id = id;
        this.name = name;
        this.durationMinutes = durationMinutes;
        this.price = price;
    }

    public Long getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getDurationMinutes() { return durationMinutes; }
    public void setDurationMinutes(Integer durationMinutes) { this.durationMinutes = durationMinutes; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    @Override
    public String toString() {
        return name + " $" + price;
    }

    @Override
    public int hashCode(){
        final int config = 13;
        return config * id.hashCode() + config * name.hashCode() + config * durationMinutes.hashCode() + config * price.hashCode() + config;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Service other = (Service) obj;
        return this.id.equals(other.id)
                && this.name.equals(other.name)
                && this.durationMinutes.equals(other.durationMinutes)
                && this.price.equals(other.price);
    }

    @Override
    public double applyDiscount(double percent) {
        return price - (price * percent / 100);
    }

    @Override
    public double getOriginalPrice() {
        return price;
    }
}