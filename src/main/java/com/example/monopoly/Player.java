package com.example.monopoly;

import java.util.ArrayList;

import com.example.monopoly.places.Place;

public class Player {
    private String name;
    private String tokenColor;
    private int money;
    private int position;
    private ArrayList<Deed> deeds = new ArrayList<>();
    private int jogadasSeguidas;

    public Player(String name, String tokenColor) {
        this.name = name;
        this.tokenColor = tokenColor;
        this.money = 1500;
        this.position = 40;
        this.jogadasSeguidas = 0;
    }

    public String getName() {
        return name;
    }

    public String getPlayerToken() {
        return tokenColor;
    }

    public int getPlayerMoney() {
        return money;
    }

    public void setPlayerMoney(int money) {
        this.money = money;
    }

    public int getPlayerPosition() {
        return position;
    }

    public void setPlayerPosition(int position) {
        this.position = position;
    }

    public void mover(int steps) {
        position = (position + steps - 1) % 40 + 1;
    }

    public void decreaseMoney(int value){ money -= value; }
    public void increaseMoney(int value) {
        money += value;
    }

    public void buy(Place place) {
        if (money >= place.getPrice()) {
            setPlayerMoney(money -= place.getPrice());
            place.setOwner(this);

            if (place.getGroup() != null) {
                addDeed(new Deed(place.getName(), place.getGroup(), place.getPrice()));
                System.out.println(getName() + " bought a realestate " + place.getName() + " for $" + place.getPrice() + ".");
            } else {
                addDeed(new Deed(place.getName(), " ", place.getPrice()));
                System.out.println(getName() + " bought a property " + place.getName() + " for $" + place.getPrice() + ".");
            }
            
            
        } else {
            System.out.println(getName() + ", you don't have enough money to buy this property.");
        }
    }


    public void addDeed(Deed deed) {
        deeds.add(deed);
    }

    public ArrayList<Deed> getDeeds() {
        return deeds;
    }

    public void resetarJogadas() {
        jogadasSeguidas = 0;
    }

    public void incrementarJogadas() {
        jogadasSeguidas++;
    }

    public int getJogadasSeguidas() {
        return jogadasSeguidas;
    }

    public boolean bankruptcy(Player player) {
        return money < 0;
    }
    
    public void voltar(int places, Board board) {

        int newPosition = getPlayerPosition() - places;
        if (newPosition < 1) {
            newPosition += 40;
        }

        setPlayerPosition(newPosition);
        System.out.println("The player " + getName() + " come back " + places + " places.");
        Place place = board.getPlace(places);
        System.out.println("Current Position: " + getPlayerPosition() + " in " + place.getName());
    }
}