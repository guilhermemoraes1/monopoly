package com.example.monopoly.casas.abstract_factory;

import com.example.monopoly.casas.Chance;

public interface ChanceFactory {
    Chance createChance(int position, String name);
}
