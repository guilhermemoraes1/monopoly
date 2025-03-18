package com.example.monopoly.places.abstract_factory;

import com.example.monopoly.Board;
import com.example.monopoly.places.StartingPoint;

public interface StartingPointFactory {
    StartingPoint createStartingPoint(int position, String name, Board board);
}
