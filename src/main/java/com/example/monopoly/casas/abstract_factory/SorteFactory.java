package com.example.monopoly.casas.abstract_factory;

import com.example.monopoly.casas.Sorte;

public interface SorteFactory {
    Sorte criarSorte(int posicao, String nome);
}
