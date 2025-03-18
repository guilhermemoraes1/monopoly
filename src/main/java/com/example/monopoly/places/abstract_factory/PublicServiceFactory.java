package com.example.monopoly.places.abstract_factory;

import com.example.monopoly.places.PublicService;

public interface PublicServiceFactory {
    PublicService createPublicService(int position, String name, int price);
}
