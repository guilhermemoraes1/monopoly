package com.example.monopoly;

public class Place {
    private String name;
    private String group;
    private int price;
    private int rent;
    private String owner;

    public Place(String name, String group, int price, int rent, String owner) {
        this.name = name;
        this.group = group;
        this.price = price;
        this.rent = rent;
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public int getPrice() {
        return price;
    }

    public int getRent() {
        return rent;
    }

    public String getOwner() {
        return owner;
    }
}