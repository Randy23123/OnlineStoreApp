package com.pluralsight;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class OnlineStoreApp {
    public static HashMap<String, Product> inventory = new HashMap<String, Product>();
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws FileNotFoundException{


        int choice = 0;
        while (choice != 3) {
        System.out.println("Store Home Screen");
        System.out.println("1.Display product");
        System.out.println("2.Display your Cart");
        System.out.println("3.Exit");

            try {
                choice = scanner.nextInt();

                switch (choice){
                    case 1:
                        DisplayProduct();
                        break;
                    case 2:
                        displayCart();
                        break;
                    case 3:
                        System.out.println("you have exited :)");
                        break;
                    default:
                        System.out.println("Wrong pick one of the option");
                }
            }
            catch (IOException e){
                System.out.println("Error");
            }
        }
    }

    public static void displayCart() throws IOException{

    }



    private static void loadInventory() throws IOException {
        FileReader fileReader = new FileReader("src/main/resources/products.csv");
        BufferedReader buffReader = new BufferedReader(fileReader);
        String input;

        String productName;
        String productID;
        double productPrice;
        String productDep;
        boolean firstLine = true;
        while ((input = buffReader.readLine()) != null) {
            if (firstLine) {
                firstLine = false;
                continue;
            }
            String[] temp = input.split("\\|");
            productID = temp[0].toUpperCase();
            productName = temp[1];
            productDep = temp[3];
            try {
                productPrice = Double.parseDouble(temp[2]);
            } catch (NumberFormatException e) {
                continue;
            }
            inventory.put(productID, new Product(productID, productName, productPrice, productDep));
        }
        buffReader.close();
    }


    public static void DisplayProduct() throws IOException{
        loadInventory();
        while (true) {
            for (Product p : inventory.values()) {
                System.out.printf("Sku: %s productName: %s - Price: $%.2f department: %s\n", p.getId(), p.getName(), p.getPrice(), p.getDep());
            }
            System.out.print("\nWhat item # are you interested in? ");
            String id = scanner.next().toUpperCase();
            Product matchedProduct = inventory.get(id);
            if (matchedProduct == null) {
                System.out.println("We don't carry that product");
                return;
            }
            System.out.printf("\nWe carry %s and the price is $%.2f", matchedProduct.getName(), matchedProduct.getPrice(), matchedProduct.getDep());
            System.out.println("\nDo you want it?: ");
            String item = scanner.next();
            if (item.equalsIgnoreCase("y")) {
                System.out.println("Now added to your cart!");
                System.out.println("\nAre there any more items you would like:");
                String item1 = scanner.next();
                if (item1.equalsIgnoreCase("n")) {
                    System.out.println("going back to store page :)\n");
                    break;  }
            }
        }
    }
}
