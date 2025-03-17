package com.example.monopoly.casas.abstract_factory;

import com.example.monopoly.casas.CofreComunitario;

public interface CofreComunitarioFactory {

    CofreComunitario criarCofreComunitario(int posicao, String nome);
}
