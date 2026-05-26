package com.pluralsight.thegoods;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testOrderTotal {
    @Test
    public void testOrderTotal() {

        Order order = new Order();

        order.addProduct(new Drink("large", "coke"));

        order.addProduct(new Taco("single", "soft"));

        order.addProduct(new ChipsAndSalsa("medium", "mild"));

        double expected = 6;

        assertEquals(expected, order.getTotalPrice());


    }
}