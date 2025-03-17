package com.example.monopoly.casas.abstract_factory;

import com.example.monopoly.casas.Ferrovia;

public interface FerroviaFactory {
    Ferrovia createFerrovia(int posicao, String nome, int preco, int corrida);
}
