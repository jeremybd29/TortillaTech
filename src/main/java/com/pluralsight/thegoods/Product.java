package com.pluralsight.thegoods;

// abstract parent class

public abstract class Product
    implements Priceable {

    //shared name for all products
    private String name;

    //constructor
    public Product(String name) {

        this.name = name;

    }

    //getter for name
    public String getName() {
        return name;

    }

    //setter
    public void setName(String name) {
        this.name = name;
    }

    //abstract method: child classes define their own logic for calculating price
    @Override
    public abstract double getPrice();

    @Override
    public String toString() {
        return "Product: " + name + ", price: " + getPrice();
    }
}

