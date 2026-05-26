package com.pluralsight.thegoods;

import java.util.Scanner;

public class UserInterface {

    private Scanner scanner;

    //constructor
    public UserInterface() {
        scanner = new Scanner(System.in);
    }

    //start application
    // main loop keeps app running until user chooses exit
    public void display() {
        boolean exit = false;
        while (!exit) {
            System.out.println("Welcome to The Goods! Please select an option:");
            System.out.println("1. Create a new order");
            System.out.println("2. Exit");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    newOrder();
                    break;
                case "2":
                    exit = true;
                    System.out.println("Thank you for visiting The Goods! Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    //home screen
    private void displayHomeScreen(){

        System.out.println();
        System.out.println("=== TORTILLA TECH ===");

        System.out.println("1. Create a new order");
        System.out.println("0. Exit");

        System.out.print("Select option: ");
    }

    //new order
    //creates order, object stores: tacos,drinks,chips
    private void newOrder() {
        Order order = new Order();

        boolean ordering = true;

        while (ordering) {
            displayOrderScreen();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1:
                    addTaco(order);
                    break;

                case 2:
                    addDrink(order);
                    break;

                case 3:
                    addChipsAndSalsa(order);
                    break;

                case 0:
                    ordering = false;
                    System.out.println("Order cancelled. Returning to home screen.");
                    break;
            }
        }
    }
    //order screen displayed

    private void displayOrderScreen() {

        System.out.println();

        System.out.println("=== CREATE YOUR ORDER ===");
        System.out.println("1. Add Taco");
        System.out.println("2. Add Drink");
        System.out.println("3. Add Chips & Salsa");
        System.out.println("0) cancel order");

        System.out.print("Select option: ");
    }
    //Add Taco(Object)
    private void addTaco(Order order) {
        System.out.println();

        //collect taco size
        System.out.print("Select taco size (Single, 3 Tacos, Burrito): ");
        String size = scanner.nextLine();

        //collect type
        System.out.print("Select shell type (Corn, Flour, bowl): ");
        String shell = scanner.nextLine();

        //taco object
        Taco taco = new Taco(size, shell);

        //temperature ingredient later user selects ingredients dynamically.
        taco.addIngredient(new Ingredients("Beef", "Meat", false));

        order.addProduct(taco);
        System.out.println("Taco added to order!");
    }
    //add drink
    private void addDrink(Order order) {

        System.out.print("Select drink size (Small, Medium, Large): ");
        String size = scanner.nextLine();

        System.out.print("Drink flavor: ");

        String flavor = scanner.nextLine();

        //drink object
        Drink drink = new Drink(size, flavor);

        order.addProduct(drink);
        System.out.println("Drink added to order!");
    }

    //add chips and salsa
    private void addChipsAndSalsa(Order order) {

        System.out.print("Select salsa type (Mild, Medium, Hot): ");
        String salsaType = scanner.nextLine();
        String chipsType = "Regular";

        //chips object
        ChipsAndSalsa chipsAndSalsa = new ChipsAndSalsa(salsaType, chipsType);

        order.addProduct(chipsAndSalsa);
        System.out.println("Chips & Salsa added to order!"
        );
    }

    //checkout
    //displays entire order
    private void checkout(Order order){

        System.out
    }

}
