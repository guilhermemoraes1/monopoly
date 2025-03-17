package com.example.monopoly.commands;

import java.util.Scanner;

import com.example.monopoly.MonopolyGame;
import com.example.monopoly.Player;

public class QuitCommand implements Command {
    @Override
    public void execute(MonopolyGame game, Player player) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nVocê tem certeza de que quer sair (Sim/Não)? ");
        String confirmacao = scanner.nextLine();

        if ("Sim".equalsIgnoreCase(confirmacao)) {

            System.out.println("\nAté a próxima!");
            game.quitGame();

        } else {
            System.out.println("Continuando o jogo.\n");
        }
    }
}