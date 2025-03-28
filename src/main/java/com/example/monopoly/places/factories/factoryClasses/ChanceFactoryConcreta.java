package com.example.monopoly.places.factories.factoryClasses;

import com.example.monopoly.places.Place;
import com.example.monopoly.Board;
import com.example.monopoly.places.Chance;
import com.example.monopoly.places.factories.ChanceFactory;

public class ChanceFactoryConcreta implements ChanceFactory {
    @Override
    public Chance createChance(int position, String name, Board board, Place place) {
            return new Chance(position, name, board, place);
    }
}
