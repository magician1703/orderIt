package com.zagurskiy.dishes;

public class MainCourse extends Delicious{

    public MainCourse(String name, Float price) {
        super(name, price);
    }

    @Override
    public void print() {
        System.out.println(this.getName() + " in price " + this.getPrice());
    }

    @Override
    public Float getPrice() {
        return super.getPrice();
    }
}
