package com.example.monopoly.commands;

import com.example.monopoly.MonopolyGame;
import com.example.monopoly.Player;

public class QuitCommand implements Command {
    @Override
    public void execute(MonopolyGame game, Player player) {
        game.quitGame();
    }
}
