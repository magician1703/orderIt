package com.zagurskiy.dishes;

import com.zagurskiy.cuisine.Cuisine;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CuiseneTest {

    Cuisine cuisene1;
    Drink drink1;
    Drink drink2;
    Dessert dessert1;
    MainCourse mainCourse1;
    MainCourse mainCourse2;
    MainCourse mainCourse3;

    @Before
    public void setUp() throws Exception {
        cuisene1 =  new Cuisine("Polish");
        drink1 = new Drink("Fanta", 2.3F);
        drink2 = new Drink("Kola", 3.2F);
        dessert1 = new Dessert("Napoleon", 5.2F);
        mainCourse1 = new MainCourse("Ramen", 6.2F);
        mainCourse2 = new MainCourse("Soup of tomato", 5.3F);
        mainCourse3 = new MainCourse("Soup of chicken", 5.7F);
    }

    @Test
    public void addTwoDrinksShouldReturnSizeIncreaseByTwo() {
        cuisene1.getDrinks().add(drink1);
        cuisene1.getDrinks().add(drink2);
        assertEquals(cuisene1.getDrinks().size(),2);
    }

    @Test
    public void addOneDessertShouldReturnSizeIncreaseByOne() {
        cuisene1.getDesserts().add(dessert1);
        assertEquals(cuisene1.getDesserts().size(),1);
    }

    @Test
    public void addThreeMainCoursesShouldReturnSizeIncreaseByThree() {
        cuisene1.getMainCourses().add(mainCourse1);
        cuisene1.getMainCourses().add(mainCourse2);
        cuisene1.getMainCourses().add(mainCourse3);
        assertEquals(cuisene1.getMainCourses().size(),3);
    }

    @Test
    public void setNameOfCuiseneToAustralianShouldReturnAustralian() {
        cuisene1.setNameOfCuisene("Australian");
        assertEquals(cuisene1.getNameOfCuisene(),"Australian");
    }
}