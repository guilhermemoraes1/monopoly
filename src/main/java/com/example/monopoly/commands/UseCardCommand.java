package com.example.monopoly.commands;

import com.example.monopoly.MonopolyGame;
import com.example.monopoly.Player;

public class UseCardCommand implements Command {
    @Override
    public void execute(MonopolyGame game, Player player) {}

    @Override
    public void execute(Player player) {
        System.out.println("You used a card to leave the jail!");
        player.resetarJogadas();
    }

}