package com.example.monopoly.casas.command;

import java.util.Scanner;

import com.example.monopoly.Player;

public class ComandoStatus implements Comando{
    @Override
    public void executar(Player player, Scanner scanner) {
        System.out.println("Status da prisão");
    }
}
