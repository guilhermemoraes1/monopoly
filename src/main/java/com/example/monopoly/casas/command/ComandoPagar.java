package com.example.monopoly.casas.command;

import java.util.Scanner;

import com.example.monopoly.Player;

public class ComandoPagar implements Comando {
    @Override
    public void executar(Player peca, Scanner scanner) {
        int valorFianca = 50;

        if (peca.getPlayerMoney() >= valorFianca) {

            System.out.println("Você pagou para sair da prisão!");
            peca.diminuirDinheiro(valorFianca);
            peca.resetarJogadas();

        } else {
            System.out.println("Você não tem dinheiro suficiente para pagar a fiança e sair da prisão.");
        }
    }
}
