package com.zagurskiy.cuisine;

import com.zagurskiy.dishes.Dessert;
import com.zagurskiy.dishes.Drink;
import com.zagurskiy.dishes.MainCourse;

import java.util.ArrayList;

public class Cuisine {

    private String nameOfCuisene;

    private ArrayList <MainCourse> mainCourses;
    private ArrayList <Dessert> desserts;
    private ArrayList <Drink> drinks;

    public Cuisine(String nameOfCuisene) {
        this.nameOfCuisene = nameOfCuisene;
        mainCourses = new ArrayList<>();
        desserts = new ArrayList<>();
        drinks = new ArrayList<>();
    }

    public void addMainCourse(MainCourse newMainCourse) {
        this.mainCourses.add(newMainCourse);
    }

    public void addDessert(Dessert newDessert) {
        this.desserts.add(newDessert);
    }

    public void addDrink(Drink newDrink) {
        this.drinks.add(newDrink);
    }

    public String getNameOfCuisene() {
        return nameOfCuisene;
    }

    public ArrayList<MainCourse> getMainCourses() {
        return mainCourses;
    }

    public ArrayList<Dessert> getDesserts() {
        return desserts;
    }

    public ArrayList<Drink> getDrinks() {
        return drinks;
    }

    public void setNameOfCuisene(String nameOfCuisene) {
        this.nameOfCuisene = nameOfCuisene;
    }
}
