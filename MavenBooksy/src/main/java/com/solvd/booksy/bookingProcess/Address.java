package com.solvd.booksy.bookingProcess;

public final class Address {

    private String city;
    private String street;
    private String building;
    private String zipCode;

    public Address(){}

    public Address(String city, String street, String building, String zipCode) {
        this.city = city;
        this.street = street;
        this.building = building;
        this.zipCode = zipCode;
    }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getStreet() { return street; }
    public void setStreet(String street) { this.street = street; }

    public String getBuilding() { return building; }
    public void setBuilding(String building) { this.building = building; }

    public String getZipCode() { return zipCode; }
    public void setZipCode(String zipCode) { this.zipCode = zipCode; }

    @Override
    public String toString() {
        return city + " " + street + " " + building +" " + zipCode;
    }

    @Override
    public int hashCode(){
        final int config = 31;
        return config * city.hashCode() + config * street.hashCode() + config * building.hashCode() + config * zipCode.hashCode() + config;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (this.hashCode() != obj.hashCode()) return false;
        Address other = (Address) obj;
        return this.city.equals(other.city)
                && this.street.equals(other.street)
                && this.building.equals(other.building)
                && this.zipCode.equals(other.zipCode);
    }
}