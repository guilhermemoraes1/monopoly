package com.example.monopoly.cards;

import com.example.monopoly.Player;
import com.example.monopoly.places.Place;

public abstract class Cards {

    private int number;
    private String name;
    private String description;
    private Place place;

    public Cards(int number, String name, String description, Place place){
        this.number = number;
        this.name = name;
        this.description = description;
        this.place = place;
    }

    public int getNumber() {
        return number;
    }

    public Place getPlace() {
        return place;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public abstract void executarAcao(Player player);
}
