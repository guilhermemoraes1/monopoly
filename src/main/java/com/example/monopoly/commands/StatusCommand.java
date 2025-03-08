package com.example.monopoly.commands;

import com.example.monopoly.MonopolyGame;
import com.example.monopoly.Player;

public class StatusCommand implements Command {
    @Override
    public void execute(MonopolyGame game, Player player) {
        System.out.println("Player: " + player.getName());
        System.out.println("Color: " + player.getPlayerToken());
        System.out.println("Money: " + player.getPlayerMoney());
        System.out.println("Position: " + player.getPlayerPosition());
        System.out.println("Deeds: " + player.getPlayerDeeds());
    }
}