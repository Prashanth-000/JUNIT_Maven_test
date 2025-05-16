package com.example;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class BusinessService {

    /* ---------- booking section ---------- */
    private final Set<LocalDate> bookedDates = new HashSet<>();

    /** @return true if booking succeeded, false when date already taken */
    public boolean bookDate(LocalDate date) {
        if (bookedDates.contains(date)) return false;
        bookedDates.add(date);
        return true;
    }

    /** @return true when given date has NOT been booked yet */
    public boolean isDateAvailable(LocalDate date) {
        return !bookedDates.contains(date);
    }

    /* ---------- invoice section ---------- */
    /**
     * Calculates total bill = subtotal + tax − discount.
     * @throws IllegalArgumentException when discount is negative
     */
    public double calculateTotalWithDiscount(double subtotal,
                                             double taxPercent,
                                             double discount) {
        if (discount < 0) throw new IllegalArgumentException("Discount cannot be negative");
        double tax = subtotal * (taxPercent / 100);
        return (subtotal + tax) - discount;
    }
}
