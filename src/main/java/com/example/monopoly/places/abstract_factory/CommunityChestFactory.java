package com.example.monopoly.places.abstract_factory;

import com.example.monopoly.places.Place;
import com.example.monopoly.Board;
import com.example.monopoly.places.CommunityChest;

public interface CommunityChestFactory {

    CommunityChest createCommunityChest(int position, String name, Board board, Place place);
}
