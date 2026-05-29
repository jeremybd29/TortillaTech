package com.pluralsight.thegoods;

public class ChipsAndSalsa extends Product {

    private String salsaType;
    private String chips;

    //constructor
    public ChipsAndSalsa(String salsaType, String chips) {
        super("Chips and Salsa");
        this.salsaType = salsaType;
        this.chips = chips;
    }

    //getters
    public String getSalsaType() {
        return salsaType;
    }
    public String getChips(){
        return chips;
    }
    //price
    @Override
    public double getPrice() {
        return 3.50;
    }

    @Override
    public String toString() {
        return "Chips & Salsa ("+
                salsaType + ") $"
                +String.format("%.2f",
                getPrice());
    }
}
