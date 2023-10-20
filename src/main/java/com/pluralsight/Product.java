package com.pluralsight;

public class Product {
    private String id;
    private String name;
    private double price;
    private String dep;

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
}