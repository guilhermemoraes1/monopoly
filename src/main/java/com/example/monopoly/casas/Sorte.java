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
    public void executarAcao(Player player) {
        System.out.println(" e o peão avançou para " + player.getPlayerPosition() + " – " + player.getName()  + ".");
        System.out.println("Tirou carta de Chance");

    }
}
