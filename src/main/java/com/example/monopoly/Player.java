package com.example.monopoly;

import java.util.HashSet;
import java.util.Set;

public class Player {
    private String name;
    private String tokenColor;
    private int money;
    private int position;
    private Set<String> deeds;

    public Player(String name, String tokenColor) {
        this.name = name;
        this.tokenColor = tokenColor;
        this.money = 1500;
        this.position = 40;
        this.deeds = new HashSet<>();
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

    public int getPlayerPosition() {
        return position;
    }

    public Set<String> getPlayerDeeds() {
        return deeds;
    }

    
}