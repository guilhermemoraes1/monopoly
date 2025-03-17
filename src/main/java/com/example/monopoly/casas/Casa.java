package com.example.monopoly.casas;

import com.example.monopoly.Player;

public abstract class Casa {
    private int posicao;
    private String nome;
    private Player proprietario;

    public Casa(int posicao, String nome){
        this.posicao = posicao;
        this.nome = nome;
        this.proprietario = null;
    }

    public String getName(){
        return nome;
    }
    public int getPosicao(){
        return posicao;
    }
    public Player getProprietario() {
        return proprietario;
    }
    public void setProprietario(Player proprietario) {
        this.proprietario = proprietario;
    }
    public abstract void oferecerCompra(Player player);
    public abstract void venderPara(Player player);
    public  abstract void executarAcao(Player player);
}