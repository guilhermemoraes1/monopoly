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
    public void executarAcao(Player peca) {
        System.out.println(" e o peão avançou para " + getPosicao() + " – " + getName());

        int impostoRiqueza = 75;
        int impostoRenda = 200;

        if(!isImpostoRiqueza()){
            // pagar imposto de renda
            System.out.println("O jogador " + peca.getName() + " pagou $" + impostoRenda + " de imposto de renda.");
            peca.diminuirDinheiro(impostoRenda);
            System.out.println("Novo saldo: $" + peca.getPlayerMoney() + "\n");

        } else {
            // pagar imposto de riqueza
            System.out.println("O jogador " + peca.getName() + " pagou $" + impostoRiqueza + " de imposto de riqueza.");
            peca.diminuirDinheiro(impostoRiqueza);
            System.out.println("Novo saldo: $" + peca.getPlayerMoney() + "\n");
        }

    }
}
