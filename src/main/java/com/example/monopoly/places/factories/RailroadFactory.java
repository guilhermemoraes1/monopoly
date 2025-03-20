package com.example.monopoly.places.factories;

import com.example.monopoly.Board;
import com.example.monopoly.places.Railroad;

public interface RailroadFactory {
    Railroad createRailroad(int position, String name, int price, int race, Board board);
}
