package com.example.monopoly.casas.abstract_factory;

import com.example.monopoly.casas.RealEstate;

public interface RealEstateFactory {
    RealEstate createRealEstate(int position, String name, String grupo, int price, int rent);
}
