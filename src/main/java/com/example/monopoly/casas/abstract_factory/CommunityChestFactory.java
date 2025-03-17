package com.example.monopoly.casas.abstract_factory;

import com.example.monopoly.casas.CommunityChest;

public interface CommunityChestFactory {

    CommunityChest createCommunityChest(int position, String name);
}
