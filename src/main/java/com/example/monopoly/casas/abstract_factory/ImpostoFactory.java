package com.example.monopoly.casas.abstract_factory;

import com.example.monopoly.casas.Imposto;

public interface ImpostoFactory {
    Imposto criarImposto(int posicao, String nome, boolean impostoRiqueza);
}
