package com.zagurskiy.dishes;

public abstract class Delicious {
    private String name;
    private Float price;

    public  Delicious() {
        this.name = "";
        this.price = 0F;
    }

    public Delicious(String name, Float price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public Float getPrice() {
        return this.price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public abstract void print();
}
