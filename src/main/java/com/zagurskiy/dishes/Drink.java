package com.zagurskiy.dishes;

public class Drink extends Delicious{

    private boolean withIce;
    private boolean withLemon;

    public Drink(String name, Float price) {
        super(name, price);
    }

    @Override
    public void print() {
        System.out.print( this.getName());
        if(this.withLemon && this.withIce) System.out.print(" with ice and lemon");
        else if(this.withLemon || this.withIce) System.out.print(" with " + ((this.withIce) ? "ice" : "lemon"));
    }

    @Override
    public Float getPrice() {
        return super.getPrice();
    }

    public boolean isWithIce() {
        return withIce;
    }

    public boolean isWithLemon() {
        return withLemon;
    }

    public void setWithLemon(boolean withLemon) {
        this.withLemon = withLemon;
    }

    public void setWithIce(boolean withIce) {
        this.withIce = withIce;
    }
}
