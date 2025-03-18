package com.example.monopoly.cartas;

import com.example.monopoly.Player;
import com.example.monopoly.places.Place;

public abstract class Cartas {

    private int numero;
    private String nome;
    private String descricao;
    private Place place;

    public Cartas(int numero, String nome, String descricao, Place place){
        this.numero = numero;
        this.nome = nome;
        this.descricao = descricao;
        this.place = place;
    }

    public int getNumero() {
        return numero;
    }

    public Place getPlace() {
        return place;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public abstract void executarAcao(Player peca);

}
