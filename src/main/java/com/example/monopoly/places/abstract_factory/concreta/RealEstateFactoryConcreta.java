package com.example.monopoly.places.abstract_factory.concreta;

import com.example.monopoly.places.RealEstate;
import com.example.monopoly.places.abstract_factory.RealEstateFactory;

public class RealEstateFactoryConcreta implements RealEstateFactory {
    @Override
    public RealEstate createRealEstate(int position, String name, String grupo, int price, int race) {
        return new RealEstate(position, name, grupo, price, race);
    }
}
