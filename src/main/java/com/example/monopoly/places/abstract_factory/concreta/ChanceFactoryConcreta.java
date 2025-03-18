package com.example.monopoly.places.abstract_factory.concreta;

import com.example.monopoly.places.Chance;
import com.example.monopoly.places.abstract_factory.ChanceFactory;

public class ChanceFactoryConcreta implements ChanceFactory {
    @Override
    public Chance createChance(int position, String name) {
        return new Chance(position, name);
    }
}
