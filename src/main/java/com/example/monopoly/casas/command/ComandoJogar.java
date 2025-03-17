package com.example.monopoly.casas.command;

import java.util.Scanner;

import com.example.monopoly.Player;

public class ComandoJogar implements Comando {

    @Override
    public void executar(Player peca, Scanner scanner) {

        int dado1 = (int) (Math.random() * 6) + 1; 
        int dado2 = (int) (Math.random() * 6) + 1; 

        System.out.println("\nO jogador " + peca.getName() + " tirou " + dado1 + "," + dado2);

        if (dado1 == dado2) {

            System.out.println("Você saiu da prisão!\n");
            peca.resetarJogadas();

        } else {
            System.out.println("Você não conseguiu sair da prisão.");
            peca.incrementarJogadas();
        }

    }

}
