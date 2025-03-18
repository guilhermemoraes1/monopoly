package com.example.monopoly.places.abstract_factory;

import com.example.monopoly.places.Chance;

public interface ChanceFactory {
    Chance createChance(int position, String name);
}
