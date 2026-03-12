package com.solvd.booksy.interfaces;

public interface Discountable {
    double applyDiscount(double percent);
    double getOriginalPrice();
}