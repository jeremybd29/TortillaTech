package com.pluralsight.thegoods;

import java.util.ArrayList;

//taco class inheritance taco is product
public class Taco extends Product{

    private String size;
    private String shell;

    //taco has collection of ingredients
    private ArrayList<Ingredients> ingredients;

    //optional extras
    private boolean coveredInQueso;
    private boolean guacamole;
    private boolean coveredInSalsa;

    //constructor
    public Taco(String size, String shell){

        //calling product constructor
        super("Taco");

        this.size = size;
        this.shell = shell;

        //initialize ingredients collection
        ingredients = new ArrayList<>();
    }
    // getters
    public String getSize() {
        return size;
    }
    public String getShell() {
        return shell;
    }


    public ArrayList<Ingredients> getIngredients() {
        return ingredients;
    }
    // adding ingredients to taco
    public void addIngredient(Ingredients ingredient) {
        ingredients.add(ingredient);
    }

    //salsa + queso + guac

    public boolean isCoveredInQueso() {

        return coveredInQueso;
    }

    public void setCoveredInQueso(boolean coveredInQueso) {
        this.coveredInQueso = coveredInQueso;
    }
    public boolean isGuacamole() {
        return guacamole;
    }
    public void setGuacamole(boolean guacamole) {
        this.guacamole = guacamole;
    }

    public boolean isCoveredInSalsa() {
        return coveredInSalsa;
    }
    public void setCoveredInSalsa(boolean coveredInSalsa) {
        this.coveredInSalsa = coveredInSalsa;
    }
    //pricing, calculates taco total price
    @Override
    public double getPrice() {
        double total = 0;

        //base price

        if(size.equalsIgnoreCase("single")) {
            total += 2.50;
        } else if (size.equalsIgnoreCase("3 tacos")) {
            total += 10.00;
        }
        else if (size.equalsIgnoreCase("burrito")) {
            total += 9.00;
        }

        //stream for adding ingredients
        total += ingredients.stream()
                .mapToDouble(ingredient -> ingredient.getPrice(size))
                .sum();

        //extras
        if (coveredInQueso) {
            total += 1.50;
        }
        if (guacamole) {
            total += 1.00;
        }
        if (coveredInSalsa) {
            total += 0.50;
        }

        return total;
    }
    //display taco details
    @Override
    public String toString() {
        String text = "";

        text += size + "Taco\n";
        text += "Shell: " + shell + "\n";
        text += "Ingredients:\n";

        for (Ingredients ingredient : ingredients) {
            text += "- " + ingredient + "\n";
        }

        //display extras
        if (coveredInQueso) {
            text += "- Covered in Queso\n";
        }
        if (guacamole) {
            text += "- Guacamole\n";
        }
        if (coveredInSalsa) {
            text += "- Covered in Salsa\n";
        }

        text += "Price: $" + String.format("%.2f", getPrice());

        return text;


}

}
