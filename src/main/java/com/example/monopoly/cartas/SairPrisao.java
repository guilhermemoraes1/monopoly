package com.example.monopoly.cartas;

import com.example.monopoly.Player;
import com.example.monopoly.places.Place;

public class SairPrisao extends Cartas {
    public SairPrisao(int numero, String nome, String descricao, Place place) {
        super(numero, nome, descricao, place);
    }

    @Override
    public void executarAcao(Player peca) {
        System.out.println("Sair da prisão.");
    }
}
