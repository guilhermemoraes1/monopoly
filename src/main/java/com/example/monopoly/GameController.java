package com.example.monopoly;

import com.example.monopoly.commands.Command;
import com.example.monopoly.commands.QuitCommand;
import com.example.monopoly.commands.RollCommand;
import com.example.monopoly.commands.StatusCommand;

import java.util.Map;
import java.util.LinkedHashMap;

public class GameController {
    private final Map<String, Command> commands = new LinkedHashMap<>();
    
    public GameController() {
        commands.put("roll", new RollCommand());
        commands.put("status", new StatusCommand());
        commands.put("quit", new QuitCommand());
    }

    public void processCommand(String command, MonopolyGame game) {
        Player currentPlayer = game.getCurrentPlayer();
        Command cmd = commands.get(command);
        if (cmd != null) {
            cmd.execute(game, currentPlayer);
        } else {
            System.out.println("Invalid command. Try again.");
        }
    }

    public Map<String, Command> getCommands() {
        return commands;
    }

    public void printPlayerMenu(MonopolyGame game) {
        if (!game.getIsGameOn()) {
            System.out.println("The game has ended.");
            return;
        }
        
        Player currentPlayer = game.getCurrentPlayer();
        System.out.println("\nIt's " + currentPlayer.getName() + "'s turn.");
        System.out.println("Available commands: " + getCommands().keySet());
    }
}
