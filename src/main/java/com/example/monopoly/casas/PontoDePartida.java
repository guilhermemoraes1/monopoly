package com.example.monopoly.casas;

import com.example.monopoly.Player;

public class PontoDePartida extends Casa {

    public PontoDePartida(int posicao, String nome) {
        super(posicao, nome);
    }

    @Override
    public void oferecerCompra(Player jogador) {

    }

    @Override
    public void venderPara(Player jogador) {

    }

    @Override
    public void executarAcao(Player peca) {
        System.out.println(" e o peão avançou para " + peca.getPlayerPosition() + " – " + peca.getName());
    }
}
