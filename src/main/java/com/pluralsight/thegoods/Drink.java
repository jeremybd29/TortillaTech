package com.pluralsight.thegoods;

public class Drink extends Product {

    private String size;
    private String flavor;

    //constructor
    public Drink(String size, String flavor) {
        super("Drink");
        this.size = size;
        this.flavor = flavor;
    }

    //getters
    public String getSize(){
        return size;
    }

    public String getFlavor(){
        return flavor;
    }

    //price logic for drink
    @Override
    public double getPrice() {

        switch(size.toLowerCase()) {

            case "small":
                return 2.00;
            case "medium":
                return 2.50;
            case "large":
                return 3.00;

        }
        return 0;
    }
    //display drink
    @Override
    public String toString() {

        return size + " " + flavor + " " + getName() + ", price: " + getPrice();
    }
}
