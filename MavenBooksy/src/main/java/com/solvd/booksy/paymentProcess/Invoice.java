package com.solvd.booksy.paymentProcess;

import java.time.LocalDateTime;

public class Invoice {
    private final Long id;
    private Payment payment;
    private LocalDateTime issuedAt;

    public Invoice(Long id){
        this.id = id;
    }

    public Invoice(Long id, Payment payment, LocalDateTime issuedAt) {
        this.id = id;
        this.payment = payment;
        this.issuedAt = issuedAt;
    }

    public Long getId() { return id; }
    //public void setId(Long id) { this.id = id; }

    public Payment getPayment() { return payment; }
    public void setPayment(Payment payment) { this.payment = payment; }

    public LocalDateTime getIssuedAt() { return issuedAt; }
    public void setIssuedAt(LocalDateTime issuedAt) { this.issuedAt = issuedAt; }

    @Override
    public String toString() {
        return "Your com.solvd.booksy.paymentProcess.Invoice info: " + payment + " Issued on: " + issuedAt;
    }

    @Override
    public int hashCode(){
        final int config = 5;
        return config * id.hashCode() + config * payment.hashCode() + config * issuedAt.hashCode() + config;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Invoice other = (Invoice) obj;
        return this.id.equals(other.id)
                && this.payment.equals(other.payment)
                && this.issuedAt.equals(other.issuedAt);
    }
}