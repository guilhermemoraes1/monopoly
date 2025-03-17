package com.example.monopoly.casas;

import com.example.monopoly.Player;

public class TestPlace extends Casa{
    public TestPlace(int position, String name) {
        super(position, name);
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
