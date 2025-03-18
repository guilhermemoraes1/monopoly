package com.example.monopoly.places.abstract_factory;

import com.example.monopoly.places.Railroad;

public interface RailroadFactory {
    Railroad createRailroad(int position, String name, int price, int race);
}
