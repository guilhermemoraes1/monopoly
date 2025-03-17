package com.example.monopoly.casas.abstract_factory.concreta;

import com.example.monopoly.casas.CommunityChest;
import com.example.monopoly.casas.abstract_factory.CommunityChestFactory;

public class CommunityChestFactoryConcreta implements CommunityChestFactory {
    @Override
    public CommunityChest createCommunityChest(int posicao, String nome) {
        return new CommunityChest(posicao, nome);
    }
}
