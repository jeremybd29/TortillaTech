package com.pluralsight.thegoods;

import java.util.ArrayList;

public class Order {

    private ArrayList<Product> products;

//constructor
public Order(){
products = new ArrayList<>();
}

//add product
    public void addProduct(Product product) {
        products.add(product);
    }

    //getter
    public ArrayList<Product> getProducts() {
        return products;
    }

    //total price of order
    public double getTotalPrice() {
        return products.stream()

                .mapToDouble(Product::getPrice)
                .sum();
    }

    //display order

@Override
public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("Order Details:\n");

    //stream displays product

    products.stream()

            .forEach(product -> builder.append(product).append("\n\n")
            );
    builder.append(
            "total:$"
    );

    builder.append(
            String.format(
                    "%.2f",
                    getTotalPrice()
            )
    );

    return builder.toString();
}
}
