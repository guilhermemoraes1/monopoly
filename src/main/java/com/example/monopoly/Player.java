package com.example.monopoly;

import java.util.ArrayList;

import com.example.monopoly.places.Place;
import com.example.monopoly.places.PublicService;
import com.example.monopoly.places.Railroad;
import com.example.monopoly.places.RealEstate;

public class Player {
    private String name;
    private String tokenColor;
    private int money;
    private int position;
    private ArrayList<Deed> deeds = new ArrayList<>();
    private int jogadasSeguidas;

    public Player(String name, String tokenColor) {
        this.name = name;
        this.tokenColor = tokenColor;
        this.money = 1500;
        this.position = 40;
        this.jogadasSeguidas = 0;
    }

    public String getName() {
        return name;
    }

    public String getPlayerToken() {
        return tokenColor;
    }

    public int getPlayerMoney() {
        return money;
    }

    public void setPlayerMoney(int money) {
        this.money = money;
    }

    public int getPlayerPosition() {
        return position;
    }

    public void setPlayerPosition(int position) {
        this.position = position;
    }

    public void mover(int steps) {
        position = (position + steps - 1) % 40 + 1;
    }

    public void decreaseMoney(int valor){ money -= valor; }
    public void increaseMoney(int valor) {
        money += valor;
    }

    public void buy(Place place) {
        if (money >= place.getPrice()) {
            setPlayerMoney(money -= place.getPrice());
            place.setOwner(this);

            if (place.getGroup() != null) {
                addDeed(new Deed(place.getName(), place.getGroup(), place.getPrice()));
                System.out.println(getName() + " comprou a realestate " + place.getName() + " por $" + place.getPrice() + ".");
            } else {
                addDeed(new Deed(place.getName(), " ", place.getPrice()));
                System.out.println(getName() + " comprou a propriedade " + place.getName() + " por $" + place.getPrice() + ".");
            }
            
            
        } else {
            System.out.println(getName() + ", você não tem dinheiro suficiente para comprar esta propriedade.");
        }
    }


    public void addDeed(Deed deed) {
        deeds.add(deed);
    }

    public ArrayList<Deed> getDeeds() {
        return deeds;
    }

    public void resetarJogadas() {
        jogadasSeguidas = 0;
    }

    public void incrementarJogadas() {
        jogadasSeguidas++;
    }

    public int getJogadasSeguidas() {
        return jogadasSeguidas;
    }

    public boolean bankruptcy(Player player) {
        return money < 0;
    }
    
    public void voltar(int casas, Board board) {

        int novaPosicao = getPlayerPosition() - casas;
        if (novaPosicao < 1) {
            novaPosicao += 40;
        }

        setPlayerPosition(novaPosicao);
        System.out.println("O jogador " + getName() + " voltou " + casas + " casas.");
        Place place = board.getPlace(casas);
        System.out.println("Posição atual: " + getPlayerPosition() + " em " + place.getName());
    }
}