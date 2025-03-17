package com.example.monopoly.casas.abstract_factory.concreta;

import com.example.monopoly.casas.Propriedade;
import com.example.monopoly.casas.abstract_factory.PropriedadeFactory;

public class PropriedadeFactoryConcreta implements PropriedadeFactory {
    @Override
    public Propriedade createPropriedade(int posicao, String nome, String grupo, int preco, int corrida) {
        return new Propriedade(posicao, nome, grupo, preco, corrida);
    }
}
