package com.example.monopoly.casas.abstract_factory.concreta;

import com.example.monopoly.casas.Chance;
import com.example.monopoly.casas.abstract_factory.ChanceFactory;

public class ChanceFactoryConcreta implements ChanceFactory {
    @Override
    public Chance createChance(int position, String name) {
        return new Chance(position, name);
    }
}
