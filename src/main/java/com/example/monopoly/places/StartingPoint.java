package com.example.monopoly.places;

import com.example.monopoly.Board;
import com.example.monopoly.Player;

public class StartingPoint extends Place {

    public StartingPoint(int position, String name, Board board) {
        super(position, name, board);
    }

    @Override
    public void offerToBuy(Player player) {

    }

    @Override
    public void sellTo(Player player) {

    }

    @Override
    public void executarAcao(Player player) {
        System.out.println("The player advanced to position " + getPosition() + ", place: " + getName());
        player.increaseMoney(200);
        System.out.println("The player " + player.getName() + " received $200.");
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
