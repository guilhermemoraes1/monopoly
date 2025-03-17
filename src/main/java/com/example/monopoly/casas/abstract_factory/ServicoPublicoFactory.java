package com.example.monopoly.casas.abstract_factory;

import com.example.monopoly.casas.ServicoPublico;

public interface ServicoPublicoFactory {
    ServicoPublico criarServicoPublico(int posicao, String nome, int preco);
}
