package com.example.monopoly.casas;

import com.example.monopoly.Player;

public abstract class Casa {
    private int position;
    private String name;
    private Player proprietario;

    public Casa(int position, String name){
        this.position = position;
        this.name = name;
        this.proprietario = null;
    }

    public String getName(){
        return name;
    }
    public int getPosition(){
        return position;
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