package com.example.monopoly;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.example.monopoly.casas.Railroad;
import com.example.monopoly.casas.RealEstate;
import com.example.monopoly.casas.PublicService;

public class Player {
    private String name;
    private String tokenColor;
    private int money;
    private int position;
    private Set<String> deeds;
    private ArrayList<Titulo> titulos = new ArrayList<>();
    private int jogadasSeguidas;

    public Player(String name, String tokenColor) {
        this.name = name;
        this.tokenColor = tokenColor;
        this.money = 1500;
        this.position = 40;
        this.deeds = new HashSet<>();
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

    public Set<String> getPlayerDeeds() {
        return deeds;
    }

    public void mover(int steps) {
        position = (position + steps - 1) % 40 + 1;
    }

    public void diminuirDinheiro(int valor){ money -= valor; }
    public void aumentarDinheiro(int valor) {
        money += valor;
    }

    public void comprarRealEstate(RealEstate realestate) {
        if (money >= realestate.getPrice()) {
            setPlayerMoney(money -= realestate.getPrice());
            realestate.setProprietario(this);

            adicionarTitulo(new Titulo(realestate.getName(), realestate.getGrupo(), realestate.getPrice()));
            System.out.println(getName() + " comprou a realestate " + realestate.getName() + " por $" + realestate.getPrice() + ".");
        } else {
            System.out.println(getName() + ", você não tem dinheiro suficiente para comprar esta realestate.");
        }
    }

    public void comprarRailroad(Railroad railroad) {
        if (money >= railroad.getPrice()) {
            setPlayerMoney(money -= railroad.getPrice());

            adicionarTitulo(new Titulo(railroad.getName(), " ", railroad.getPrice()));
            System.out.println(getName() + " comprou a railroad " + railroad.getName() + " por $" + railroad.getPrice() + ".");
        } else {
            System.out.println(getName() + ", você não tem dinheiro suficiente para comprar esta railroad.");
        }
    }

    public void comprarPublicService(PublicService PublicService){
        if(money >= PublicService.getPrice()){
            setPlayerMoney(money -= PublicService.getPrice());

            adicionarTitulo(new Titulo(PublicService.getName(), " ", PublicService.getPrice()));
            System.out.println(getName() + " comprou o seviço público " + PublicService.getName() + " por $" + PublicService.getPrice() + ".");
        } else {
            System.out.println(getName() + ", você não tem dinheiro suficiente para comprar este serviço.");
        }
    }

    public void adicionarTitulo(Titulo titulo) {
        titulos.add(titulo);
    }

    public ArrayList<Titulo> getTitulos() {
        return titulos;
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
    
}