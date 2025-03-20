package com.example.monopoly.places.factories;

import com.example.monopoly.Board;
import com.example.monopoly.places.Chance;
import com.example.monopoly.places.Place;

public interface ChanceFactory {
    Chance createChance(int position, String name, Board board, Place place);
}
