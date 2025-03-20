package com.example.monopoly.places.factories;

import com.example.monopoly.Board;
import com.example.monopoly.places.RealEstate;

public interface RealEstateFactory {
    RealEstate createRealEstate(int position, String name, String grupo, int price, int rent, Board board);
}
