package com.example.monopoly.casas.command;

import java.util.Scanner;

import com.example.monopoly.Player;

public interface Comando {
    // Uso do padrão comportamental 'Command' para tratar os comandos da classe Prisão
    void executar(Player player, Scanner scanner);
}
