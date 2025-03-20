package com.example.monopoly.commands;

import com.example.monopoly.MonopolyGame;
import com.example.monopoly.Player;

public interface Command {
    void execute(MonopolyGame game, Player player);
    void execute(Player player);
}
