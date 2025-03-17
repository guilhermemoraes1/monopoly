package com.example.monopoly;

import java.util.ArrayList;

import com.example.monopoly.casas.Railroad;
import com.example.monopoly.casas.RealEstate;
import com.example.monopoly.casas.PublicService;

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

    public void mover(int steps) {
        position = (position + steps - 1) % 40 + 1;
    }

    public void decreaseMoney(int valor){ money -= valor; }
    public void increaseMoney(int valor) {
        money += valor;
    }

    public void comprarRealEstate(RealEstate realestate) {
        if (money >= realestate.getPrice()) {
            setPlayerMoney(money -= realestate.getPrice());
            realestate.setProprietario(this);

            addDeed(new Deed(realestate.getName(), realestate.getGrupo(), realestate.getPrice()));
            System.out.println(getName() + " comprou a realestate " + realestate.getName() + " por $" + realestate.getPrice() + ".");
        } else {
            System.out.println(getName() + ", você não tem dinheiro suficiente para comprar esta realestate.");
        }
    }

    public void comprarRailroad(Railroad railroad) {
        if (money >= railroad.getPrice()) {
            setPlayerMoney(money -= railroad.getPrice());

            addDeed(new Deed(railroad.getName(), " ", railroad.getPrice()));
            System.out.println(getName() + " comprou a railroad " + railroad.getName() + " por $" + railroad.getPrice() + ".");
        } else {
            System.out.println(getName() + ", você não tem dinheiro suficiente para comprar esta railroad.");
        }
    }

    public void comprarPublicService(PublicService PublicService){
        if(money >= PublicService.getPrice()){
            setPlayerMoney(money -= PublicService.getPrice());

            addDeed(new Deed(PublicService.getName(), " ", PublicService.getPrice()));
            System.out.println(getName() + " comprou o seviço público " + PublicService.getName() + " por $" + PublicService.getPrice() + ".");
        } else {
            System.out.println(getName() + ", você não tem dinheiro suficiente para comprar este serviço.");
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
    
}