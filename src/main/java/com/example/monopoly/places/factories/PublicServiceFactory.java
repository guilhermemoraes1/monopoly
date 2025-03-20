package com.example.monopoly.places.factories;

import com.example.monopoly.Board;
import com.example.monopoly.places.PublicService;

public interface PublicServiceFactory {
    PublicService createPublicService(int position, String name, int price, Board board);
}
