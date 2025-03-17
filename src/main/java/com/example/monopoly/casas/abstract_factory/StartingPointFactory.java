package com.example.monopoly.casas.abstract_factory;

import com.example.monopoly.casas.StartingPoint;

public interface StartingPointFactory {
    StartingPoint createStartingPoint(int position, String name);
}
