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
            displayHomeScreen();

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
            String choice = scanner.nextLine();

            switch (choice) {

                case "1":
                    addTaco(order);
                    break;

                case "2":
                    addDrink(order);
                    break;

                case "3":
                    addChipsAndSalsa(order);
                    break;

                case "4":
                    checkout(order);
                    ordering = false;
                    break;

                case "0":
                    ordering = false;
                    System.out.println("Order cancelled. Returning to home screen.");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
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
        System.out.println("4. Checkout");
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
        System.out.print("Select shell type (Corn, Flour, blue corn): ");
        String shell = scanner.nextLine();

        //taco object
        Taco taco = new Taco(size, shell);

        // user selects ingredients dynamically.
       addMeat(taco);
         addIngredient(taco);
        addQueso(taco);
        addSauces(taco);
        addExtras(taco);


        order.addProduct(taco);
        System.out.println("Taco added to order!");
    }

    private void addSauces(Taco taco) {
    }

    private void addExtras(Taco taco) {
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

        //calling toString method of order
        System.out.println(order);

        ReceiptFileManager.saveReceipt(order);

        System.out.println("Order complete. Confirmation sent via email");
    }
    //methods for dynamic taco ingredients
    private void addMeat(Taco taco) {
        System.out.println();
        System.out.print("Select meat (Chicken, Beef, Pork, Al Pastor): ");
        String choice = scanner.nextLine();
        String meatName = "";

        switch (choice){

            case "Chicken":
                meatName = "Chicken";
                break;
            case "Beef":
                meatName = "Beef";
                break;
            case "Pork":
                meatName = "Pork";
                break;
            case "Al Pastor":
                meatName = "Al Pastor";
                break;

            default:
                System.out.println("Invalid meat selection");
                return;
        }
        //extra meat
        System.out.print("Add extra meat? (yes/no): ");
        String extraInput = scanner.nextLine();

        boolean extraMeat = extraInput.equalsIgnoreCase("yes");

        //create ingredient object and add to taco
        Ingredients meat = new Ingredients(meatName, "meat", extraMeat);
        taco.addIngredient(meat);
        System.out.println(meatName + " added to taco!");
    }
    //method for dynamic taco ingredients
    private void addIngredient(Taco taco) {
        System.out.print("Select ingredient (onion, cilantro, salsa verde, salsa roja): ");
        String choice = scanner.nextLine();
        String ingredientName = "";

        switch (choice) {
            case "onion":
                ingredientName = "onion";
                break;
            case "cilantro":
                ingredientName = "cilantro";
                break;
            case "salsa verde":
                ingredientName = "salsa verde";
                break;
            case "salsa roja":
                ingredientName = "salsa roja";
                break;
            default:
                System.out.println("Invalid ingredient selection");
                return;
        }
        //create ingredient object and add to taco
        Ingredients ingredient = new Ingredients(ingredientName, "regular", false);
        taco.addIngredient(ingredient);
        System.out.println(ingredientName + " added to taco!");
    }

    //method for Queso
    private void addQueso(Taco taco) {
        System.out.print("Add queso? (yes/no): ");
        String input = scanner.nextLine();
        boolean addQueso = input.equalsIgnoreCase("yes");
        taco.setCoveredInQueso(addQueso);
        if (addQueso) {
            System.out.println("Queso added to taco!");
        }
    }

}
