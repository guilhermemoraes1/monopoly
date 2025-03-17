package com.example.monopoly.casas.jailCommands;

import com.example.monopoly.Player;

public class ComandoCarta implements Comando{
    @Override
    public void executar(Player player) {
        System.out.println("Você usou uma carta para sair da prisão!");
        player.resetarJogadas();
    }
}
