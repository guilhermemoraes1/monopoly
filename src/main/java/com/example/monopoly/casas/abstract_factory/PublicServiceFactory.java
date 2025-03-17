package com.example.monopoly.casas.abstract_factory;

import com.example.monopoly.casas.PublicService;

public interface PublicServiceFactory {
    PublicService createPublicService(int position, String name, int price);
}
