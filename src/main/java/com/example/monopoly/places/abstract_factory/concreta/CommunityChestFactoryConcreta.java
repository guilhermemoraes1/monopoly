package com.example.monopoly.places.abstract_factory.concreta;

import com.example.monopoly.places.CommunityChest;
import com.example.monopoly.places.abstract_factory.CommunityChestFactory;

public class CommunityChestFactoryConcreta implements CommunityChestFactory {
    @Override
    public CommunityChest createCommunityChest(int position, String name) {
        return new CommunityChest(position, name);
    }
}
