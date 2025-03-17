package com.example.monopoly.casas;

import com.example.monopoly.Player;

public class CasaTeste extends Casa{
    public CasaTeste(int posicao, String nome) {
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
        System.out.println(" e o peão avançõu para " + player.getPlayerPosition() + " – " + getName());

    }
}
