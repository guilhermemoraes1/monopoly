package com.example.monopoly.casas.abstract_factory.concreta;

import com.example.monopoly.casas.Imposto;
import com.example.monopoly.casas.abstract_factory.ImpostoFactory;

public class ImpostoFactoryConcreta implements ImpostoFactory {
    @Override
    public Imposto criarImposto(int posicao, String nome, boolean impostoRiqueza) {
        return new Imposto(posicao, nome, impostoRiqueza);
    }
}
