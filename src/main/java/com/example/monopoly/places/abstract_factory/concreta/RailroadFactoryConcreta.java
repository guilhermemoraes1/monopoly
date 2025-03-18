package com.example.monopoly.places.abstract_factory.concreta;

import com.example.monopoly.Board;
import com.example.monopoly.places.Railroad;
import com.example.monopoly.places.abstract_factory.RailroadFactory;

public class RailroadFactoryConcreta implements RailroadFactory {
    @Override
    public Railroad createRailroad(int position, String name, int price, int rent, Board board) {
        return new Railroad(position, name, price, rent, board);
    }
}
