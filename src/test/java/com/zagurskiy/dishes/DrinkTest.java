package com.zagurskiy.dishes;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DrinkTest {

    private Drink drink;
    @Before
    public void setUp() throws Exception {
        drink = new Drink("kola", 3.5F);
    }

    @Test
    public void setDrinkNameFantaShouldReturnFanta() {
        drink.setName("Fanta");
        assertEquals("Fanta", drink.getName());
    }

    @Test
    public void setIsWithLemonTrueShouldReturnTrue(){
        drink.setWithLemon(true);
        assertTrue(drink.isWithLemon());
    }
}