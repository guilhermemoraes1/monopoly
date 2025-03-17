package com.example.monopoly.casas;

import com.example.monopoly.Player;

public class Tax extends Casa{
    private boolean taxRiqueza;
    public Tax(int position, String name, boolean taxRiqueza) {
        super(position, name);
        this.taxRiqueza = taxRiqueza;
    }

    public boolean isTaxRiqueza() {
        return taxRiqueza;
    }

    public void setTaxRiqueza(boolean taxRiqueza) {
        this.taxRiqueza = taxRiqueza;
    }

    @Override
    public void oferecerCompra(Player jogador) {

    }

    @Override
    public void venderPara(Player jogador) {

    }

    @Override
    public void executarAcao(Player player) {
        System.out.println(" e o peão avançou para " + getPosition() + " – " + getName());

        int taxRiqueza = 75;
        int taxRenda = 200;

        if(!isTaxRiqueza()){
            // pagar tax de renda
            System.out.println("O jogador " + player.getName() + " pagou $" + taxRenda + " de tax de renda.");
            player.diminuirDinheiro(taxRenda);
            System.out.println("Novo saldo: $" + player.getPlayerMoney() + "\n");

        } else {
            // pagar tax de riqueza
            System.out.println("O jogador " + player.getName() + " pagou $" + taxRiqueza + " de tax de riqueza.");
            player.diminuirDinheiro(taxRiqueza);
            System.out.println("Novo saldo: $" + player.getPlayerMoney() + "\n");
        }

    }
}
