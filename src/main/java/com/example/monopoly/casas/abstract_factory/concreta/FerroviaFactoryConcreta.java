package com.example.monopoly.casas.abstract_factory.concreta;

import com.example.monopoly.casas.Ferrovia;
import com.example.monopoly.casas.abstract_factory.FerroviaFactory;

public class FerroviaFactoryConcreta implements FerroviaFactory {
    @Override
    public Ferrovia createFerrovia(int posicao, String nome, int preco, int aluguel) {
        return new Ferrovia(posicao, nome, preco, aluguel);
    }
}
