package com.pluralsight.thegoods;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TacoTest {

    @Test
    public void testSingleTacoPrice() {
        Taco taco = new Taco("single", "soft");
        taco.addIngredient(new Ingredients("chicken", "meat", false)
        );
        taco.addIngredient(new Ingredients("lettuce", "regular", false)
        );
        taco.addIngredient(new Ingredients("salsa", "sauce", false)
        );

        double expected = 4.0;

        assertEquals(expected, taco.getPrice()
        );
    }

}