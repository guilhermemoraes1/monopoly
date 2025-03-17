package com.example.monopoly.casas.abstract_factory;

import com.example.monopoly.casas.PontoDePartida;

public interface PontoDePartidaFactory {
    PontoDePartida createPontoDePartida(int posicao, String nome);
}
