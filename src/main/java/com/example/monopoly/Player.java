package com.example.monopoly;

import java.util.LinkedHashSet;
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
        this.deeds = new LinkedHashSet<>();
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

    public void setPosition(int position) {
        this.position = position;
    }

    // Método para diminuir o dinheiro do jogador
    public void setPlayerMoney(int money) {
        this.money = money;
    }

    // Método para adicionar uma propriedade ao conjunto de "deeds"
    public void addDeed(String deed) {
        this.deeds.add(deed);
    }
}