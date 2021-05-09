package com.zagurskiy.dishes;

public class Dessert extends Delicious{
    public Dessert(String name, Float price) {
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
