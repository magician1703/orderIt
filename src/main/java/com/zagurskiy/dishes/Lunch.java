package com.zagurskiy.dishes;

public class Lunch extends Delicious{

    private Delicious mainCourse;
    private Delicious dessert;

    public Lunch(Delicious mainCourse , Delicious dessert) {
        this.mainCourse = mainCourse;
        this.dessert =  dessert;
    }

    public Float getPrice(){
        return this.mainCourse.getPrice() + this.dessert.getPrice();
    }

    @Override
    public void print() {
        this.mainCourse.print();
        this.dessert.print();
        Float totally = this.getPrice();
        System.out.println("Totally you must pay for lunch: " + totally);
    }

    public Delicious getMainCourse() {
        return mainCourse;
    }

    public Delicious getDessert() {
        return dessert;
    }

    public void setMainCourse(Delicious mainCourse) {
        this.mainCourse = mainCourse;
    }

    public void setDessert(Delicious dessert) {
        this.dessert = dessert;
    }
}
