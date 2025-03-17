package com.example.monopoly.casas.abstract_factory;

import com.example.monopoly.casas.Propriedade;

public interface PropriedadeFactory {
    Propriedade createPropriedade(int posicao, String nome, String grupo, int preco, int aluguel);
}
