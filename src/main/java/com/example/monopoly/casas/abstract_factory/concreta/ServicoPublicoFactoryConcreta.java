package com.example.monopoly.casas.abstract_factory.concreta;

import com.example.monopoly.casas.ServicoPublico;
import com.example.monopoly.casas.abstract_factory.ServicoPublicoFactory;

public class ServicoPublicoFactoryConcreta implements ServicoPublicoFactory {
    @Override
    public ServicoPublico criarServicoPublico(int posicao, String nome, int preco) {
        return new ServicoPublico(posicao, nome, preco);
    }
}
