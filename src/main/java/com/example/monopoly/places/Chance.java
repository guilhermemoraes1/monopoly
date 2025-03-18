package com.example.monopoly.places;

import com.example.monopoly.Player;

public class Chance extends Place {


    public Chance(int position, String name){
        super(position, name);
    }

    @Override
    public void offerToBuy(Player player) {

    }

    @Override
    public void sellTo(Player player) {

    }

    @Override
    public void executarAcao(Player player) {
        System.out.println(" e o peão avançou para " + player.getPlayerPosition() + " – " + player.getName()  + ".");
        System.out.println("Tirou carta de Chance");

    }

    @Override
    public int getPrice() {
        return 0;
    };

    @Override
    public String getGroup() {
        return null;
    };
}
