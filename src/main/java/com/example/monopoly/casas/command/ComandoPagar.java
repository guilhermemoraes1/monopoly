package com.example.monopoly.casas.command;

import java.util.Scanner;

import com.example.monopoly.Player;

public class ComandoPagar implements Comando {
    @Override
    public void executar(Player player, Scanner scanner) {
        int fineValue = 50;

        if (player.getPlayerMoney() >= fineValue) {

            System.out.println("Você pagou para sair da prisão!");
            player.diminuirDinheiro(fineValue);
            player.resetarJogadas();

        } else {
            System.out.println("Você não tem dinheiro suficiente para pagar a fiança e sair da prisão.");
        }
    }
}
