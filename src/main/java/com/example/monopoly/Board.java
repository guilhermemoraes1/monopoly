package com.example.monopoly;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.example.monopoly.places.Place;
import com.example.monopoly.places.TestPlace;
import com.example.monopoly.places.abstract_factory.ChanceFactory;
import com.example.monopoly.places.abstract_factory.CommunityChestFactory;
import com.example.monopoly.places.abstract_factory.JailFactory;
import com.example.monopoly.places.abstract_factory.PublicServiceFactory;
import com.example.monopoly.places.abstract_factory.RailroadFactory;
import com.example.monopoly.places.abstract_factory.RealEstateFactory;
import com.example.monopoly.places.abstract_factory.StartingPointFactory;
import com.example.monopoly.places.abstract_factory.TaxFactory;
import com.example.monopoly.places.abstract_factory.concreta.ChanceFactoryConcreta;
import com.example.monopoly.places.abstract_factory.concreta.CommunityChestFactoryConcreta;
import com.example.monopoly.places.abstract_factory.concreta.JailFactoryConcreta;
import com.example.monopoly.places.abstract_factory.concreta.PublicServiceFactoryConcreta;
import com.example.monopoly.places.abstract_factory.concreta.RailroadFactoryConcreta;
import com.example.monopoly.places.abstract_factory.concreta.RealEstateFactoryConcreta;
import com.example.monopoly.places.abstract_factory.concreta.StartingPointFactoryConcreta;
import com.example.monopoly.places.abstract_factory.concreta.TaxFactoryConcreta;

public class Board {

    private final int maxCasaId = 40;

    private ArrayList<Place> places;

    public Board() {
        places = new ArrayList<>();
        initializePlaces();
    }

    private void initializePlaces() {
        RealEstateFactory realestateFactory = new RealEstateFactoryConcreta();
        CommunityChestFactory communityChestFactory = new CommunityChestFactoryConcreta();
        RailroadFactory railroadFactory = new RailroadFactoryConcreta();
        PublicServiceFactory publicServiceFactory = new PublicServiceFactoryConcreta();
        ChanceFactory chanceFactory = new ChanceFactoryConcreta();
        TaxFactory taxFactory = new TaxFactoryConcreta();
        JailFactory jailFactory = new JailFactoryConcreta();
        StartingPointFactory startingPointFactory = new StartingPointFactoryConcreta();

        places.add(realestateFactory.createRealEstate(1, "Mediterranean Avenue",  "roxo",  60,  2));
        places.add(communityChestFactory.createCommunityChest(2, "Cofre Comunitário 1"));
        places.add(realestateFactory.createRealEstate(3, "Baltic Avenue", "roxo", 60,  4));
        places.add(taxFactory.createTax(4, "Tax de Renda", false));
        places.add(railroadFactory.createRailroad(5, "Reading Railroad",  200, 0));
        places.add(realestateFactory.createRealEstate(6, "Oriental Avenue", "ciano", 100,  6));
        places.add(chanceFactory.createChance(7, "Chance 1"));
        places.add(realestateFactory.createRealEstate(8, "Vermont Avenue", "ciano", 100, 6));
        places.add(realestateFactory.createRealEstate(9, "Connecticut Avenue", "ciano", 120, 8));
        places.add(jailFactory.createJail(10, "Prisão: Apenas Visitando",  true));
        places.add(realestateFactory.createRealEstate(11, "St. Charles Casa", "rosa", 140, 10));
        places.add(publicServiceFactory.createPublicService(12, "Companhia Elétrica", 150));
        places.add(realestateFactory.createRealEstate(13, "States Avenue",  "rosa", 140, 10));
        places.add(realestateFactory.createRealEstate(14, "Virginia Avenue", "rosa", 160, 12));
        places.add(railroadFactory.createRailroad(15, "Pennsylvania Railroad",  200, 0));
        places.add(realestateFactory.createRealEstate(16, "St. James Casa", "laranja", 180, 14));
        places.add(communityChestFactory.createCommunityChest(17, "Cofre Comunitário 2"));
        places.add(realestateFactory.createRealEstate(18, "Tennessee Avenue", "laranja", 180, 14));
        places.add(realestateFactory.createRealEstate(19, "New York Avenue", "laranja", 200, 16));
        places.add(new TestPlace(20, "Free Parking"));
        places.add(realestateFactory.createRealEstate(21, "Kentucky Avenue", "vermelho", 220, 18));
        places.add(chanceFactory.createChance(22, "Chance 2"));
        places.add(realestateFactory.createRealEstate(23, "Indiana Avenue", "vermelho", 220, 18));
        places.add(realestateFactory.createRealEstate(24, "Illinois Avenue", "vermelho", 240, 20));
        places.add(railroadFactory.createRailroad(25, "B & O Railroad", 200, 0));
        places.add(realestateFactory.createRealEstate(26, "Atlantic Avenue", "amarelo", 260, 22));
        places.add(realestateFactory.createRealEstate(27, "Ventnor Avenue", "amarelo", 260, 22));
        places.add(publicServiceFactory.createPublicService(28, "Companhia de Água", 150));
        places.add(realestateFactory.createRealEstate(29, "Marvin Gardens", "amarelo", 280, 24));
        places.add(jailFactory.createJail(30, "Vá para Prisão",  false));
        places.add(realestateFactory.createRealEstate(31, "Pacific Avenue", "verde", 300, 26));
        places.add(realestateFactory.createRealEstate(32, "North Carolina Avenue", "verde", 300, 26));
        places.add(communityChestFactory.createCommunityChest(33, "Cofre Comunitário 3"));
        places.add(realestateFactory.createRealEstate(34, "Pennsylvania Avenue", "verde", 320, 28));
        places.add(railroadFactory.createRailroad(35, "Short Line", 200, 0));
        places.add(chanceFactory.createChance(36, "Chance 3"));
        places.add(realestateFactory.createRealEstate(37, "Park Casa",  "azul", 350, 35));
        places.add(taxFactory.createTax(38, "Tax de Riqueza", true));
        places.add(realestateFactory.createRealEstate(39, "Boardwalk", "azul", 400, 50));
        places.add(startingPointFactory.createStartingPoint(40, "Ponto de Partida"));
    }
    

    public String getPlaceName(int placeID) {
        return getPlace(placeID).getName();
    }

    public Place getPlaceInPosition(int position) {
        for (Place place : places) {
            if (place.getPosition() == position) {
                return place;
            }
        }
        return null;
    }

    // public String getCasaGroup(int placeID) {
    //     return getCasa(placeID).getGroup();
    // }

    public Player getPlaceOwner(int placeID) {
        Place place = getPlace(placeID);
        if (place.getOwner() == null) {
            throw new IllegalArgumentException("This place can't be owned");
        }
        return place.getOwner();
    }

    // public int getCasaPrice(int placeID) {
    //     Casa place = getCasa(placeID);
    //     if (place.getPrice() == 0) {
    //         throw new IllegalArgumentException("This place can't be sold");
    //     }
    //     return place.getPrice();
    // }

    // public int getPropertyRent(int placeID) {
    //     Casa place = getCasa(placeID);
    //     if (place.getRent() == 0) {
    //         throw new IllegalArgumentException("This place doesn't have a rent");
    //     }
    //     return place.getRent();
    // }

    public Place getPlace(int placeID) {
        if (placeID < 1 || placeID > maxCasaId) {
            throw new IllegalArgumentException("Casa doesn't exist");
        }
        return places.get(placeID);
    }
}
