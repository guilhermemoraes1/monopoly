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

    public void setPlayerDeeds(Set<String> deeds) {
        this.deeds = deeds;
    }

    public void addDeed(String deed) {
        this.deeds.add(deed);
    }

    public int getPlayerPosition() {
        return position;
    }

    public Set<String> getPlayerDeeds() {
        return deeds;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}