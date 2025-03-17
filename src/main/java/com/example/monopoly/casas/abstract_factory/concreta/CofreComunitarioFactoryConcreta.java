package com.example.monopoly.casas.abstract_factory.concreta;

import com.example.monopoly.casas.CofreComunitario;
import com.example.monopoly.casas.abstract_factory.CofreComunitarioFactory;

public class CofreComunitarioFactoryConcreta implements CofreComunitarioFactory {
    @Override
    public CofreComunitario criarCofreComunitario(int posicao, String nome) {
        return new CofreComunitario(posicao, nome);
    }
}
