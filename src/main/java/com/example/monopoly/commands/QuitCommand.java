package com.example.monopoly.commands;

import java.util.Scanner;

import com.example.monopoly.MonopolyGame;
import com.example.monopoly.Player;

public class QuitCommand implements Command {
    @Override
    public void execute(MonopolyGame game, Player player) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nAre you sure you want to leave (yes/no)? ");
        String confirmation = scanner.nextLine();

        if ("yes".equalsIgnoreCase(confirmation)) {
            game.quitGame();

        } else {
            System.out.println("Continue with the game.\n");
        }

    }

    @Override
    public void execute(Player player) {}
}