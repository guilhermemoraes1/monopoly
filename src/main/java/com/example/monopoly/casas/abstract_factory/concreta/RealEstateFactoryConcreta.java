package com.example.monopoly.casas.abstract_factory.concreta;

import com.example.monopoly.casas.RealEstate;
import com.example.monopoly.casas.abstract_factory.RealEstateFactory;

public class RealEstateFactoryConcreta implements RealEstateFactory {
    @Override
    public RealEstate createRealEstate(int position, String name, String grupo, int price, int race) {
        return new RealEstate(position, name, grupo, price, race);
    }
}
