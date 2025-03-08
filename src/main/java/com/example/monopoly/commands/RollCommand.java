package com.example.monopoly.commands;

import com.example.monopoly.MonopolyGame;
import com.example.monopoly.Player;

public class RollCommand implements Command {
    @Override
    public void execute(MonopolyGame game, Player player) {
        System.out.println(player.getName() + " rolled the dice!");
    }
}
