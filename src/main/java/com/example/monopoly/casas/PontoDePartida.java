package com.example.monopoly.casas;

import com.example.monopoly.Player;

public class PontoDePartida extends Casa {

    public PontoDePartida(int posicao, String nome) {
        super(posicao, nome);
    }

    @Override
    public void oferecerCompra(Player player) {

    }

    @Override
    public void venderPara(Player player) {

    }

    @Override
    public void executarAcao(Player player) {
        System.out.println(" e o peão avançou para " + player.getPlayerPosition() + " – " + player.getName());
    }
}
