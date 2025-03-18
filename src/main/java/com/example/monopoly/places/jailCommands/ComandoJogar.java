package com.example.monopoly.places.jailCommands;

import com.example.monopoly.Player;

public class ComandoJogar implements Comando {

    @Override
    public void executar(Player player) {

        int dice1 = (int) (Math.random() * 6) + 1; 
        int dice2 = (int) (Math.random() * 6) + 1; 

        System.out.println("\nO player " + player.getName() + " tirou " + dice1 + "," + dice2);

        if (dice1 == dice2) {

            System.out.println("Você saiu da prisão!\n");
            player.resetarJogadas();

        } else {
            System.out.println("Você não conseguiu sair da prisão.");
            player.incrementarJogadas();
        }

    }

}
