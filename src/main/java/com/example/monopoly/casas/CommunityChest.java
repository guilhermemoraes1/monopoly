package com.example.monopoly.casas;


import com.example.monopoly.Player;

public class CommunityChest extends Casa {


    public CommunityChest(int position, String name){
        super(position, name);
    }


    @Override
    public void oferecerCompra(Player jogador) {

    }

    @Override
    public void venderPara(Player jogador) {

    }

    public void executarAcao(Player player) {
        System.out.println(" e o peão avançou para " + player.getPlayerPosition() + " – " + player.getName() + ".");
        System.out.println("Tirou carta de CommunityChest");
    }
}
