package com.example.monopoly.casas.abstract_factory;

import com.example.monopoly.casas.Prisao;

public interface PrisaoFactory {
    Prisao criarPrisao(int posicao, String nome, boolean visitandoPrisao);
}
