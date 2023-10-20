package com.pluralsight;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
public class OnlineStoreApp {
    public static HashMap<String, Product> inventory =
            new HashMap<String, Product>();
    public static void main(String[] args) throws IOException {
        loadInventory();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome here is my inventory!");
        for (Product p : inventory.values()) {
            System.out.printf("id: %d %s - Price: $%.2f\n", p.getId(), p.getName(), p.getPrice());
        }

        while (true) {
            System.out.print("\nWhat item # are you interested in ? ");
            int id = scanner.nextInt();
            Product matchedProduct = inventory.get(id);
            if (matchedProduct == null) {
                System.out.println("We don't carry that product");
                return;
            }
            System.out.printf("We carry %s and the price is $%.2f", matchedProduct.getName(), matchedProduct.getPrice());

            System.out.println("\nAre there anymore items you would like:");
            String item = scanner.next();
            if (item.equalsIgnoreCase("n")) {
                break;
            }
        }
    }

    private static void loadInventory() throws IOException {
        FileReader fileReader = new FileReader("src/main/resources/products.csv");
        BufferedReader buffReader = new BufferedReader(fileReader);
        String input;

        String productName;
        String productID;
        double productPrice;
        while ((input = buffReader.readLine()) != null){
            String[] temp = input.split("\\|");
            productID = (temp[0]);
            productName = temp[1];
            productPrice = Double.parseDouble(temp[2]);
            
            inventory.put(productID,new Product(productID, productName, productPrice));
        }
    }
}