package com.example.monopoly.cards;

import com.example.monopoly.Player;
import com.example.monopoly.places.Place;

public class GoToJailCard extends Cards {
    public GoToJailCard(int number, String name, String description, Place place) {
        super(number, name, description, place);
    }

    @Override
    public void executarAcao(Player player) {
        

        player.setPlayerPosition(30);
        System.out.println("The player " + getName() + " is in jail.");


    }
}
