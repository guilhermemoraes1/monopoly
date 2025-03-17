package com.example.monopoly.casas.jailCommands;

import com.example.monopoly.Player;

public class ComandoStatus implements Comando{
    @Override
    public void executar(Player player) {
        System.out.println("Status da prisão");
    }
}
