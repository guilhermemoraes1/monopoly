package com.example.monopoly.casas.abstract_factory.concreta;

import com.example.monopoly.casas.StartingPoint;
import com.example.monopoly.casas.abstract_factory.StartingPointFactory;

public class StartingPointFactoryConcreta implements StartingPointFactory {
    @Override
    public StartingPoint createStartingPoint(int position, String name) {
        return new StartingPoint(position, name);
    }
}
