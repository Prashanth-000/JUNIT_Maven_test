package com.example;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class BusinessServiceTest {

    /* ---------- booking tests ---------- */

    @Test
    void bookingSuccess() {
        BusinessService svc = new BusinessService();
        assertTrue(svc.bookDate(LocalDate.of(2025, 5, 20)));
    }

    @Test
    void duplicateBookingFails() {
        BusinessService svc = new BusinessService();
        LocalDate date = LocalDate.of(2025, 5, 21);
        svc.bookDate(date);
        assertFalse(svc.bookDate(date));    
    }

    /* ---------- invoice tests ---------- */

    @Test
    void invoiceNormalCase() {
        BusinessService svc = new BusinessService();
        double total = svc.calculateTotalWithDiscount(100, 10, 5);
        assertEquals(105, total, 0.001);            // 100 +10% -5 = 105
    }

    @Test
    void negativeDiscountThrows() {
        BusinessService svc = new BusinessService();
        assertThrows(IllegalArgumentException.class,
                () -> svc.calculateTotalWithDiscount(100, 10, -1));
    }

    /* -------- intentionally failing test ---------- */

    /**
     * ❌ This test is written WRONG on purpose so you can see a failure in the report.
     * We “expect” 90 but the real answer is 105, so JUnit will flag it red.
     */
    @Test
    void failingInvoiceExpectation() {
        BusinessService svc = new BusinessService();
        double total = svc.calculateTotalWithDiscount(100, 10, 5);
        assertEquals(105, total, 0.001);             // ← deliberate mistake give 105 instead 90 to pass
    }
}
