package com.example.monopoly;

public class Deed {
    private String name;
    private String color;
    private int price;

    public Deed(String name, String color, int price) {
        this.name = name;
        this.color = color;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    // melhorar depois, mas funciona
    @Override
    public String toString() {
        return "Deed{name='" + name + "', price=" + price + "}";
    }

}