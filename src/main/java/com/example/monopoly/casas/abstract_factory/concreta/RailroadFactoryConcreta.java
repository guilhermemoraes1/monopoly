package com.example.monopoly.casas.abstract_factory.concreta;

import com.example.monopoly.casas.Railroad;
import com.example.monopoly.casas.abstract_factory.RailroadFactory;

public class RailroadFactoryConcreta implements RailroadFactory {
    @Override
    public Railroad createRailroad(int position, String name, int price, int rent) {
        return new Railroad(position, name, price, rent);
    }
}
