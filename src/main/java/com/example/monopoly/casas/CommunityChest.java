package com.example.monopoly.casas;


import com.example.monopoly.Player;

public class CommunityChest extends Casa {


    public CommunityChest(int position, String name){
        super(position, name);
    }


    @Override
    public void offerToBuy(Player player) {

    }

    @Override
    public void sellTo(Player player) {

    }

    public void executarAcao(Player player) {
        System.out.println(" e o peão avançou para " + player.getPlayerPosition() + " – " + player.getName() + ".");
        System.out.println("Tirou carta de CommunityChest");
    }
}
