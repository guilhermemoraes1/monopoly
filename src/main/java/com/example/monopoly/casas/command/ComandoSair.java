package com.example.monopoly.casas.command;

import com.example.monopoly.Player;

import java.util.Scanner;

public class ComandoSair implements Comando {
    @Override
    public void executar(Player player, Scanner scanner) {

        System.out.print("\nVocê tem certeza de que quer sair (Sim/Não)? ");
        String confirmation = scanner.nextLine();

        if ("Sim".equalsIgnoreCase(confirmation)) {

            System.out.println("\nAté a próxima!");
            System.exit(0);

        } else {
            System.out.println("Continuando o jogo.\n");
        }
    }
}
