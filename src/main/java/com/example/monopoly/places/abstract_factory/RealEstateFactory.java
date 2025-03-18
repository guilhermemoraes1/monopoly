package com.example.monopoly.places.abstract_factory;

import com.example.monopoly.places.RealEstate;

public interface RealEstateFactory {
    RealEstate createRealEstate(int position, String name, String grupo, int price, int rent);
}
