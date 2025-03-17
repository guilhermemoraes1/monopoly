package com.example.monopoly.casas;

import com.example.monopoly.Player;

public class Imposto extends Casa{
    private boolean impostoRiqueza;
    public Imposto(int posicao, String nome, boolean impostoRiqueza) {
        super(posicao, nome);
        this.impostoRiqueza = impostoRiqueza;
    }

    public boolean isImpostoRiqueza() {
        return impostoRiqueza;
    }

    public void setImpostoRiqueza(boolean impostoRiqueza) {
        this.impostoRiqueza = impostoRiqueza;
    }

    @Override
    public void oferecerCompra(Player jogador) {

    }

    @Override
    public void venderPara(Player jogador) {

    }

    @Override
    public void executarAcao(Player player) {
        System.out.println(" e o peão avançou para " + getPosicao() + " – " + getName());

        int impostoRiqueza = 75;
        int impostoRenda = 200;

        if(!isImpostoRiqueza()){
            // pagar imposto de renda
            System.out.println("O jogador " + player.getName() + " pagou $" + impostoRenda + " de imposto de renda.");
            player.diminuirDinheiro(impostoRenda);
            System.out.println("Novo saldo: $" + player.getPlayerMoney() + "\n");

        } else {
            // pagar imposto de riqueza
            System.out.println("O jogador " + player.getName() + " pagou $" + impostoRiqueza + " de imposto de riqueza.");
            player.diminuirDinheiro(impostoRiqueza);
            System.out.println("Novo saldo: $" + player.getPlayerMoney() + "\n");
        }

    }
}
