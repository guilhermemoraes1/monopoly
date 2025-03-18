package com.example.monopoly.places;

import com.example.monopoly.Player;

public abstract class Place {
    private int position;
    private String name;
    private Player owner;
    private int price;
    private String group;

    public Place(int position, String name){
        this.position = position;
        this.name = name;
        this.owner = null;
    }

    public String getName(){
        return name;
    }

    public int getPosition(){
        return position;
    }
    public Player getOwner() {
        return owner;
    }
    public void setOwner(Player owner) {
        this.owner = owner;
    }
    public abstract void offerToBuy(Player player);
    public abstract void sellTo(Player player);
    public  abstract void executarAcao(Player player);

    public abstract int getPrice();
    public abstract String getGroup();
}