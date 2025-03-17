package com.example.monopoly.casas.abstract_factory.concreta;

import com.example.monopoly.casas.Sorte;
import com.example.monopoly.casas.abstract_factory.SorteFactory;

public class SorteFactoryConcreta implements SorteFactory {
    @Override
    public Sorte createSorte(int posicao, String nome) {
        return new Sorte(posicao, nome);
    }
}
