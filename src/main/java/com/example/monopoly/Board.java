package com.example.monopoly;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.example.monopoly.casas.Casa;
import com.example.monopoly.casas.TestPlace;
import com.example.monopoly.casas.abstract_factory.CommunityChestFactory;
import com.example.monopoly.casas.abstract_factory.RailroadFactory;
import com.example.monopoly.casas.abstract_factory.TaxFactory;
import com.example.monopoly.casas.abstract_factory.StartingPointFactory;
import com.example.monopoly.casas.abstract_factory.JailFactory;
import com.example.monopoly.casas.abstract_factory.RealEstateFactory;
import com.example.monopoly.casas.abstract_factory.PublicServiceFactory;
import com.example.monopoly.casas.abstract_factory.ChanceFactory;
import com.example.monopoly.casas.abstract_factory.concreta.CommunityChestFactoryConcreta;
import com.example.monopoly.casas.abstract_factory.concreta.RailroadFactoryConcreta;
import com.example.monopoly.casas.abstract_factory.concreta.TaxFactoryConcreta;
import com.example.monopoly.casas.abstract_factory.concreta.StartingPointFactoryConcreta;
import com.example.monopoly.casas.abstract_factory.concreta.JailFactoryConcreta;
import com.example.monopoly.casas.abstract_factory.concreta.RealEstateFactoryConcreta;
import com.example.monopoly.casas.abstract_factory.concreta.PublicServiceFactoryConcreta;
import com.example.monopoly.casas.abstract_factory.concreta.ChanceFactoryConcreta;

public class Board {

    private final int maxCasaId = 40;

    private ArrayList<Casa> casas;

    public Board() {
        casas = new ArrayList<>();
        initializeCasas();
    }

    private void initializeCasas() {
        RealEstateFactory realestateFactory = new RealEstateFactoryConcreta();
        CommunityChestFactory communityChestFactory = new CommunityChestFactoryConcreta();
        RailroadFactory railroadFactory = new RailroadFactoryConcreta();
        PublicServiceFactory publicServiceFactory = new PublicServiceFactoryConcreta();
        ChanceFactory chanceFactory = new ChanceFactoryConcreta();
        TaxFactory taxFactory = new TaxFactoryConcreta();
        JailFactory jailFactory = new JailFactoryConcreta();
        StartingPointFactory startingPointFactory = new StartingPointFactoryConcreta();

        casas.add(realestateFactory.createRealEstate(1, "Mediterranean Avenue",  "roxo",  60,  2));
        casas.add(communityChestFactory.createCommunityChest(2, "Cofre Comunitário 1"));
        casas.add(realestateFactory.createRealEstate(3, "Baltic Avenue", "roxo", 60,  4));
        casas.add(taxFactory.createTax(4, "Tax de Renda", false));
        casas.add(railroadFactory.createRailroad(5, "Reading Railroad",  200, 0));
        casas.add(realestateFactory.createRealEstate(6, "Oriental Avenue", "ciano", 100,  6));
        casas.add(chanceFactory.createChance(7, "Chance 1"));
        casas.add(realestateFactory.createRealEstate(8, "Vermont Avenue", "ciano", 100, 6));
        casas.add(realestateFactory.createRealEstate(9, "Connecticut Avenue", "ciano", 120, 8));
        casas.add(jailFactory.createJail(10, "Prisão: Apenas Visitando",  true));
        casas.add(realestateFactory.createRealEstate(11, "St. Charles Casa", "rosa", 140, 10));
        casas.add(publicServiceFactory.createPublicService(12, "Companhia Elétrica", 150));
        casas.add(realestateFactory.createRealEstate(13, "States Avenue",  "rosa", 140, 10));
        casas.add(realestateFactory.createRealEstate(14, "Virginia Avenue", "rosa", 160, 12));
        casas.add(railroadFactory.createRailroad(15, "Pennsylvania Railroad",  200, 0));
        casas.add(realestateFactory.createRealEstate(16, "St. James Casa", "laranja", 180, 14));
        casas.add(communityChestFactory.createCommunityChest(17, "Cofre Comunitário 2"));
        casas.add(realestateFactory.createRealEstate(18, "Tennessee Avenue", "laranja", 180, 14));
        casas.add(realestateFactory.createRealEstate(19, "New York Avenue", "laranja", 200, 16));
        casas.add(new TestPlace(20, "Free Parking"));
        casas.add(realestateFactory.createRealEstate(21, "Kentucky Avenue", "vermelho", 220, 18));
        casas.add(chanceFactory.createChance(22, "Chance 2"));
        casas.add(realestateFactory.createRealEstate(23, "Indiana Avenue", "vermelho", 220, 18));
        casas.add(realestateFactory.createRealEstate(24, "Illinois Avenue", "vermelho", 240, 20));
        casas.add(railroadFactory.createRailroad(25, "B & O Railroad", 200, 0));
        casas.add(realestateFactory.createRealEstate(26, "Atlantic Avenue", "amarelo", 260, 22));
        casas.add(realestateFactory.createRealEstate(27, "Ventnor Avenue", "amarelo", 260, 22));
        casas.add(publicServiceFactory.createPublicService(28, "Companhia de Água", 150));
        casas.add(realestateFactory.createRealEstate(29, "Marvin Gardens", "amarelo", 280, 24));
        casas.add(jailFactory.createJail(30, "Vá para Prisão",  false));
        casas.add(realestateFactory.createRealEstate(31, "Pacific Avenue", "verde", 300, 26));
        casas.add(realestateFactory.createRealEstate(32, "North Carolina Avenue", "verde", 300, 26));
        casas.add(communityChestFactory.createCommunityChest(33, "Cofre Comunitário 3"));
        casas.add(realestateFactory.createRealEstate(34, "Pennsylvania Avenue", "verde", 320, 28));
        casas.add(railroadFactory.createRailroad(35, "Short Line", 200, 0));
        casas.add(chanceFactory.createChance(36, "Chance 3"));
        casas.add(realestateFactory.createRealEstate(37, "Park Casa",  "azul", 350, 35));
        casas.add(taxFactory.createTax(38, "Tax de Riqueza", true));
        casas.add(realestateFactory.createRealEstate(39, "Boardwalk", "azul", 400, 50));
        casas.add(startingPointFactory.createStartingPoint(40, "Ponto de Partida"));
    }
    

    public String getCasaName(int placeID) {
        return getCasa(placeID).getName();
    }

    public Casa getCasaNaPosition(int position) {
        for (Casa casa : casas) {
            if (casa.getPosition() == position) {
                return casa;
            }
        }
        return null;
    }

    // public String getCasaGroup(int placeID) {
    //     return getCasa(placeID).getGroup();
    // }

    public Player getCasaOwner(int placeID) {
        Casa place = getCasa(placeID);
        if (place.getProprietario() == null) {
            throw new IllegalArgumentException("This place can't be owned");
        }
        return place.getProprietario();
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

    public Casa getCasa(int placeID) {
        if (placeID < 1 || placeID > maxCasaId) {
            throw new IllegalArgumentException("Casa doesn't exist");
        }
        return casas.get(placeID);
    }
}
