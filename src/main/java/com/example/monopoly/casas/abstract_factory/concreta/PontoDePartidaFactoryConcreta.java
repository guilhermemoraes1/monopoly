package com.example.monopoly.casas.abstract_factory.concreta;

import com.example.monopoly.casas.PontoDePartida;
import com.example.monopoly.casas.abstract_factory.PontoDePartidaFactory;

public class PontoDePartidaFactoryConcreta implements PontoDePartidaFactory {
    @Override
    public PontoDePartida criarPontoDePartida(int posicao, String nome) {
        return new PontoDePartida(posicao, nome);
    }
}
