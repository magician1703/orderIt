package com.zagurskiy.dishes;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LunchTest {

    Lunch lunch;
    MainCourse mainCourse;
    Dessert dessert;

    @Before
    public void setUp() throws Exception {
        mainCourse = new MainCourse("Ramen", 6.2F);
        dessert = new Dessert("Napoleon", 5.2F);
        lunch = new Lunch(mainCourse,dessert);
    }

    @Test
    public void getLunchMainCourseNameShouldReturnRamen() {
        assertSame("Ramen", lunch.getMainCourse().getName());
    }

    @Test
    public void setLunchDessertNameToBizzeShouldReturnBizze(){
        lunch.getDessert().setName("Bizze");
        assertEquals("Bizze", lunch.getDessert().getName());
    }




}