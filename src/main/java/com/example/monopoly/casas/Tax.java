package com.example.monopoly.casas;

import com.example.monopoly.Player;

public class Tax extends Casa{
    private boolean luxuryTax;
    public Tax(int position, String name, boolean luxuryTax) {
        super(position, name);
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
        System.out.println(" e o peão avançou para " + getPosition() + " – " + getName());

        int luxuryTax = 75;
        int incomeTax = 200;

        if(!isLuxuryTax()){
            // pagar tax de renda
            System.out.println("O player " + player.getName() + " pagou $" + incomeTax + " de tax de renda.");
            player.decreaseMoney(incomeTax);
            System.out.println("Novo saldo: $" + player.getPlayerMoney() + "\n");

        } else {
            // pagar tax de riqueza
            System.out.println("O player " + player.getName() + " pagou $" + luxuryTax + " de tax de riqueza.");
            player.decreaseMoney(luxuryTax);
            System.out.println("Novo saldo: $" + player.getPlayerMoney() + "\n");
        }

    }
}
