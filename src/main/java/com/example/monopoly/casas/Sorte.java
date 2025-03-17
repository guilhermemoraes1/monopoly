package com.example.monopoly.casas;

import com.example.monopoly.Player;

public class Sorte extends Casa {


    public Sorte(int posicao, String nome){
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
        System.out.println(" e o peão avançou para " + peca.getPlayerPosition() + " – " + peca.getName()  + ".");
        System.out.println("Tirou carta de Chance");

    }
}
