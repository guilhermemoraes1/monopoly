package com.example.monopoly.casas.command;

import java.util.Scanner;

import com.example.monopoly.Player;

public class ComandoCarta implements Comando{
    @Override
    public void executar(Player player, Scanner scanner) {
        System.out.println("Você usou uma carta para sair da prisão!");
        player.resetarJogadas();
    }
}
