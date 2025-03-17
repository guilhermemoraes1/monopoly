package com.example.monopoly.casas.abstract_factory;

import com.example.monopoly.casas.Railroad;

public interface RailroadFactory {
    Railroad createRailroad(int position, String name, int price, int race);
}
