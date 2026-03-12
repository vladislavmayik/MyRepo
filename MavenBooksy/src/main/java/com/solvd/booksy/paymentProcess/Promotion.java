package com.solvd.booksy.paymentProcess;

import com.solvd.booksy.exceptions.InvalidDiscountException;
import com.solvd.booksy.bookingProcess.Service;

import java.util.HashMap;
import java.util.Map;

public class Promotion {

    private static Map<String, Double> promoCodes = new HashMap<>();

    static {
        promoCodes.put("PROMO10", 0.10);
        promoCodes.put("PROMO20", 0.20);
        promoCodes.put("SUMMER", 0.15);
        promoCodes.put("WELCOME", 0.05);
    }

    public double applyDiscount(Service service, String promoCode) {
        Double discount = promoCodes.get(promoCode);
        if (discount != null) {
            return service.getPrice() * (1 - discount);
        }
        return service.getPrice();
    }

    public static void addPromoCode(String code, double discount) {
        promoCodes.put(code, discount);
    }

    public static Map<String, Double> getAllPromoCodes() {
        return promoCodes;
    }

    public double applyDiscount(Service service, double percent) throws InvalidDiscountException {
        if (percent < 0 || percent > 100) {
            throw new InvalidDiscountException("Discount percent must be between 0 and 100");
        }
        return service.getPrice() - (service.getPrice() * percent / 100);
    }
}