package com.example.monopoly.places;

import com.example.monopoly.Board;
import com.example.monopoly.Player;

public class Tax extends Place{
    private boolean luxuryTax;
    public Tax(int position, String name, boolean luxuryTax, Board board) {
        super(position, name, board);
        this.luxuryTax = luxuryTax;
    }

    public boolean isLuxuryTax() {
        return luxuryTax;
    }

    public void setLuxuryTax(boolean luxuryTax) {
        this.luxuryTax = luxuryTax;
    }

    @Override
    public void offerToBuy(Player player) {

    }

    @Override
    public void sellTo(Player player) {

    }

    @Override
    public void executarAcao(Player player) {
        System.out.println("The player advanced to position " + getPosition() + ", place: " + getName());

        int luxuryTax = 75;
        int incomeTax = 200;

        if(isLuxuryTax()){
            System.out.println("The player " + player.getName() + " paid $" + luxuryTax + " of luxury tax.");
            player.decreaseMoney(luxuryTax);
            System.out.println("New Balance: $" + player.getPlayerMoney() + "\n");
        } else {
            System.out.println("The player " + player.getName() + " paid $" + incomeTax + " of impost tax.");
            player.decreaseMoney(incomeTax);
            System.out.println("New Balance: $" + player.getPlayerMoney() + "\n");
        }

    }

    @Override
    public int getPrice() {
        return 0;
    };

    @Override
    public String getGroup() {
        return null;
    };
}
