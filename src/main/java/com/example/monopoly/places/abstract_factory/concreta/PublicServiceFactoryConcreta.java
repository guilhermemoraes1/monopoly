package com.example.monopoly.places.abstract_factory.concreta;

import com.example.monopoly.Board;
import com.example.monopoly.places.PublicService;
import com.example.monopoly.places.abstract_factory.PublicServiceFactory;

public class PublicServiceFactoryConcreta implements PublicServiceFactory {
    @Override
    public PublicService createPublicService(int position, String name, int price, Board board) {
        return new PublicService(position, name, price, board);
    }
}
