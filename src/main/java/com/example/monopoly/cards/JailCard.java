package com.example.monopoly.cards;

import com.example.monopoly.places.Jail;
import com.example.monopoly.Player;
import com.example.monopoly.places.Place;

public class JailCard extends Cards {
    public JailCard(int number, String name, String description, Place place) {
        super(number, name, description, place);
    }

    @Override
    public void executarAcao(Player player) {
        System.out.println("");
        Jail jail = new Jail(30, "Go to jail", false, null);
        jail.executarAcao(player);
    }
}
