package com.example.monopoly;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.example.monopoly.casas.Casa;
import com.example.monopoly.casas.CasaTeste;
import com.example.monopoly.casas.abstract_factory.CommunityChestFactory;
import com.example.monopoly.casas.abstract_factory.FerroviaFactory;
import com.example.monopoly.casas.abstract_factory.ImpostoFactory;
import com.example.monopoly.casas.abstract_factory.PontoDePartidaFactory;
import com.example.monopoly.casas.abstract_factory.PrisaoFactory;
import com.example.monopoly.casas.abstract_factory.PropriedadeFactory;
import com.example.monopoly.casas.abstract_factory.ServicoPublicoFactory;
import com.example.monopoly.casas.abstract_factory.SorteFactory;
import com.example.monopoly.casas.abstract_factory.concreta.CommunityChestFactoryConcreta;
import com.example.monopoly.casas.abstract_factory.concreta.FerroviaFactoryConcreta;
import com.example.monopoly.casas.abstract_factory.concreta.ImpostoFactoryConcreta;
import com.example.monopoly.casas.abstract_factory.concreta.PontoDePartidaFactoryConcreta;
import com.example.monopoly.casas.abstract_factory.concreta.PrisaoFactoryConcreta;
import com.example.monopoly.casas.abstract_factory.concreta.PropriedadeFactoryConcreta;
import com.example.monopoly.casas.abstract_factory.concreta.ServicoPublicoFactoryConcreta;
import com.example.monopoly.casas.abstract_factory.concreta.SorteFactoryConcreta;

public class Board {

    private final int maxCasaId = 40;

    private ArrayList<Casa> casas;

    public Board() {
        casas = new ArrayList<>();
        initializeCasas();
    }

    private void initializeCasas() {
        PropriedadeFactory propriedadeFactory = new PropriedadeFactoryConcreta();
        CommunityChestFactory communityChestFactory = new CommunityChestFactoryConcreta();
        FerroviaFactory ferroviaFactory = new FerroviaFactoryConcreta();
        ServicoPublicoFactory servicoPublicoFactory = new ServicoPublicoFactoryConcreta();
        SorteFactory sorteFactory = new SorteFactoryConcreta();
        ImpostoFactory impostoFactory = new ImpostoFactoryConcreta();
        PrisaoFactory prisaoFactory = new PrisaoFactoryConcreta();
        PontoDePartidaFactory pontoDePartidaFactory = new PontoDePartidaFactoryConcreta();

        casas.add(propriedadeFactory.createPropriedade(1, "Mediterranean Avenue",  "roxo",  60,  2));
        casas.add(communityChestFactory.createCommunityChest(2, "Cofre Comunitário 1"));
        casas.add(propriedadeFactory.createPropriedade(3, "Baltic Avenue", "roxo", 60,  4));
        casas.add(impostoFactory.createImposto(4, "Imposto de Renda", false));
        casas.add(ferroviaFactory.createFerrovia(5, "Reading Railroad",  200, 0));
        casas.add(propriedadeFactory.createPropriedade(6, "Oriental Avenue", "ciano", 100,  6));
        casas.add(sorteFactory.createSorte(7, "Chance 1"));
        casas.add(propriedadeFactory.createPropriedade(8, "Vermont Avenue", "ciano", 100, 6));
        casas.add(propriedadeFactory.createPropriedade(9, "Connecticut Avenue", "ciano", 120, 8));
        casas.add(prisaoFactory.createPrisao(10, "Prisão: Apenas Visitando",  true));
        casas.add(propriedadeFactory.createPropriedade(11, "St. Charles Casa", "rosa", 140, 10));
        casas.add(servicoPublicoFactory.createServicoPublico(12, "Companhia Elétrica", 150));
        casas.add(propriedadeFactory.createPropriedade(13, "States Avenue",  "rosa", 140, 10));
        casas.add(propriedadeFactory.createPropriedade(14, "Virginia Avenue", "rosa", 160, 12));
        casas.add(ferroviaFactory.createFerrovia(15, "Pennsylvania Railroad",  200, 0));
        casas.add(propriedadeFactory.createPropriedade(16, "St. James Casa", "laranja", 180, 14));
        casas.add(communityChestFactory.createCommunityChest(17, "Cofre Comunitário 2"));
        casas.add(propriedadeFactory.createPropriedade(18, "Tennessee Avenue", "laranja", 180, 14));
        casas.add(propriedadeFactory.createPropriedade(19, "New York Avenue", "laranja", 200, 16));
        casas.add(new CasaTeste(20, "Free Parking"));
        casas.add(propriedadeFactory.createPropriedade(21, "Kentucky Avenue", "vermelho", 220, 18));
        casas.add(sorteFactory.createSorte(22, "Chance 2"));
        casas.add(propriedadeFactory.createPropriedade(23, "Indiana Avenue", "vermelho", 220, 18));
        casas.add(propriedadeFactory.createPropriedade(24, "Illinois Avenue", "vermelho", 240, 20));
        casas.add(ferroviaFactory.createFerrovia(25, "B & O Railroad", 200, 0));
        casas.add(propriedadeFactory.createPropriedade(26, "Atlantic Avenue", "amarelo", 260, 22));
        casas.add(propriedadeFactory.createPropriedade(27, "Ventnor Avenue", "amarelo", 260, 22));
        casas.add(servicoPublicoFactory.createServicoPublico(28, "Companhia de Água", 150));
        casas.add(propriedadeFactory.createPropriedade(29, "Marvin Gardens", "amarelo", 280, 24));
        casas.add(prisaoFactory.createPrisao(30, "Vá para Prisão",  false));
        casas.add(propriedadeFactory.createPropriedade(31, "Pacific Avenue", "verde", 300, 26));
        casas.add(propriedadeFactory.createPropriedade(32, "North Carolina Avenue", "verde", 300, 26));
        casas.add(communityChestFactory.createCommunityChest(33, "Cofre Comunitário 3"));
        casas.add(propriedadeFactory.createPropriedade(34, "Pennsylvania Avenue", "verde", 320, 28));
        casas.add(ferroviaFactory.createFerrovia(35, "Short Line", 200, 0));
        casas.add(sorteFactory.createSorte(36, "Chance 3"));
        casas.add(propriedadeFactory.createPropriedade(37, "Park Casa",  "azul", 350, 35));
        casas.add(impostoFactory.createImposto(38, "Imposto de Riqueza", true));
        casas.add(propriedadeFactory.createPropriedade(39, "Boardwalk", "azul", 400, 50));
        casas.add(pontoDePartidaFactory.createPontoDePartida(40, "Ponto de Partida"));
    }
    

    public String getCasaName(int placeID) {
        return getCasa(placeID).getName();
    }

    public Casa getCasaNaPosicao(int position) {
        for (Casa casa : casas) {
            if (casa.getPosicao() == position) {
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
