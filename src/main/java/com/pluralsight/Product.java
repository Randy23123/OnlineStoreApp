package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private String id;
    private String name;
    private double price;
    private String dep;
    private List<Product> cartItems = new ArrayList<>();

    public Product() {
        String id;
        String name;
        double price;
        String dep;
    }

    public void addItems(Product product){
        cartItems.add(product);
    }
    public void removeItem(Product product){
        cartItems.remove(product);
    }
    public List<Product> getItems(){
        return cartItems;
    }


    public Product(String id, String name, double price, String dep){
        this.id = id;
        this.name = name;
        this.price = price;
        this.dep = dep;
    }
    public String getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public double getPrice(){
        return this.price;
    }
    public String getDep(){
        return this.dep;
    }

    public void addItem(Product matchedProduct) {
    }
}