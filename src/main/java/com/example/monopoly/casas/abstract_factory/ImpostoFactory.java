package com.example.monopoly.casas.abstract_factory;

import com.example.monopoly.casas.Imposto;

public interface ImpostoFactory {
    Imposto createImposto(int posicao, String nome, boolean impostoRiqueza);
}
