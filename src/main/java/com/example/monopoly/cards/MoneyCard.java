package com.example.monopoly.cards;

import com.example.monopoly.Player;
import com.example.monopoly.places.Place;

public class MoneyCard extends Cards{
    private int value;
    private boolean willPay;

    public MoneyCard(int number, String name, String description, int value, boolean willPay, Place place) {
        super(number, name, description, place);
        this.value = value;
        this.willPay = willPay;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean getWillPay() {
        return willPay;
    }

    public void setPay(boolean pay) {
        this.willPay = pay;
    }

    @Override
    public void executarAcao(Player player) {
        int value = getValue();

        if(getWillPay()){

            player.decreaseMoney(value);
            int currentMoney = player.getPlayerMoney();
            System.out.println("The player paid $" + value + ". New Balance: $" + currentMoney);

        } else {
            player.increaseMoney(value);
            int currentMoney = player.getPlayerMoney();
            System.out.println("The player received $" + value + ". New Balance: $" + currentMoney);

        }

    }
}
