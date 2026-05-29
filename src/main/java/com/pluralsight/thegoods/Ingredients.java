package com.pluralsight.thegoods;

public class Ingredients {

    private String name;
    private String category;
    private boolean extra;

    //constructor
    public Ingredients(String name, String category, boolean extra) {
        this.name = name;
        this.category = category;
        this.extra = extra;
    }

    //getters
    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public boolean isExtra() {
        return extra;
    }

    //setters
    public void setExtra(boolean extra) {
        this.extra = extra;
    }

    //ingredient pricing
    //depends on ingredient category and whether it's extra
    public double getPrice(String size) {
        String category = getCategory();

        //regular ingredients and sauces
        if (category.equalsIgnoreCase("regular")
                || category.equalsIgnoreCase("sauce")) {
            return 0;
        }

        //meat pricing
        if (category.equalsIgnoreCase("meat")) {
            switch (size.toLowerCase()) {

                case "single":

                    if (extra) {
                        return 3.50;
                    }
                    return 2.00;

                case "3":

                    if (extra) {
                        return 10.00;
                    }
                    return 8.50;

                case "burrito":

                    if (extra) {
                        return 13.00;
                    }
                    return 10.00;
            }
        }

        // Queso pricing

        if (category.equalsIgnoreCase("queso")) {
            switch (size.toLowerCase()) {

                case "single":

                    if (extra) {
                        return 1.00;
                    }
                    return 0.50;

                case "3 tacos":

                    if (extra) {
                        return 2.00;
                    }
                    return 1.50;

                case "burrito":

                    if (extra) {
                        return 3.00;
                    }
                    return 2.20;
            }
        }
        //default
        return 0;
    }

    //display ingredients
    @Override
    public String toString() {

        if (extra) {
            return name + "(extra)";
        }
        return name;
    }
}

