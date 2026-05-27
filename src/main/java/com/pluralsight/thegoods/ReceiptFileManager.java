package com.pluralsight.thegoods;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptFileManager {

    public static void saveReceipt(Order order) {
        // code to save the receipt to a file
        //create timestamp
        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");

        String fileName = "receipts/receipt_" + now.format(formatter) + ".txt";

        //writing receipt

        try(FileWriter fileWriter = new FileWriter(fileName);

            PrintWriter writer = new PrintWriter(fileWriter)) {

            writer.println(order);
            System.out.println("Receipt saved");
        } catch (IOException e) {
            System.out.println("Error saving receipt: " + e.getMessage());
        }

    }

}
