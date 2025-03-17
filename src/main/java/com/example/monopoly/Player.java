package com.example.monopoly;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.example.monopoly.casas.Ferrovia;
import com.example.monopoly.casas.Propriedade;
import com.example.monopoly.casas.ServicoPublico;

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

    public void comprarPropriedade(Propriedade propriedade) {
        if (money >= propriedade.getPreco()) {
            setPlayerMoney(money -= propriedade.getPreco());
            propriedade.setProprietario(this);

            adicionarTitulo(new Titulo(propriedade.getName(), propriedade.getGrupo(), propriedade.getPreco()));
            System.out.println(getName() + " comprou a propriedade " + propriedade.getName() + " por $" + propriedade.getPreco() + ".");
        } else {
            System.out.println(getName() + ", você não tem dinheiro suficiente para comprar esta propriedade.");
        }
    }

    public void comprarFerrovia(Ferrovia ferrovia) {
        if (money >= ferrovia.getPreco()) {
            setPlayerMoney(money -= ferrovia.getPreco());

            adicionarTitulo(new Titulo(ferrovia.getName(), " ", ferrovia.getPreco()));
            System.out.println(getName() + " comprou a ferrovia " + ferrovia.getName() + " por $" + ferrovia.getPreco() + ".");
        } else {
            System.out.println(getName() + ", você não tem dinheiro suficiente para comprar esta ferrovia.");
        }
    }

    public void comprarServicoPublico(ServicoPublico servicoPublico){
        if(money >= servicoPublico.getPreco()){
            setPlayerMoney(money -= servicoPublico.getPreco());

            adicionarTitulo(new Titulo(servicoPublico.getName(), " ", servicoPublico.getPreco()));
            System.out.println(getName() + " comprou o seviço público " + servicoPublico.getName() + " por $" + servicoPublico.getPreco() + ".");
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