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
        switch (size.toLowerCase()){
            case "single":
                total += 3.00;
                break;
            case "3 tacos":
                total += 8.00;
                break;
            case "burrito":
                total += 10.00;
                break;
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
        StringBuilder builder = new StringBuilder();

        builder.append(size)
                .append("Taco\n");

        builder.append("Shell:")
                .append(shell)
                .append("\n");

        builder.append("Shell:")
                .append(shell)
                .append("\n");

        builder.append("Ingredients:\n");

        //stream for ingredients
        ingredients.stream()

                .forEach(ingredient -> builder.append("- ")
                        .append(ingredient)
                        .append("\n")

                );
builder.append(
        String.format( "Price: $%.2f", getPrice() )
);
return builder.toString();


}

}
