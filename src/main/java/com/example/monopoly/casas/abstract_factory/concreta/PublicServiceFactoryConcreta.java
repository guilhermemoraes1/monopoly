package com.example.monopoly.casas.abstract_factory.concreta;

import com.example.monopoly.casas.PublicService;
import com.example.monopoly.casas.abstract_factory.PublicServiceFactory;

public class PublicServiceFactoryConcreta implements PublicServiceFactory {
    @Override
    public PublicService createPublicService(int position, String name, int price) {
        return new PublicService(position, name, price);
    }
}
