package com.example.monopoly.casas;

import com.example.monopoly.Player;

public class StartingPoint extends Casa {

    public StartingPoint(int position, String name) {
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
        System.out.println(" e o peão avançou para " + player.getPlayerPosition() + " – " + player.getName());
    }
}
