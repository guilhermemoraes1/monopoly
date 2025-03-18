package com.example.monopoly.cartas;

import com.example.monopoly.Player;
import com.example.monopoly.places.Place;

public class Pagamento extends Cartas{
    private int valor;
    private boolean pagar;

    public Pagamento(int numero, String nome, String descricao, int valor, boolean pagar, Place place) {
        super(numero, nome, descricao, place);
        this.valor = valor;
        this.pagar = pagar;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public boolean isPagar() {
        return pagar;
    }

    public void setPagar(boolean pagar) {
        this.pagar = pagar;
    }

    @Override
    public void executarAcao(Player peca) {
        int valor = getValor();

        if(isPagar()){

            peca.decreaseMoney(valor);
            int dinheiroAtual = peca.getPlayerMoney();
            System.out.println("O jogador pagou $" + valor + ". Novo saldo: $" + dinheiroAtual);

        } else {

            peca.increaseMoney(valor);
            int dinheiroAtual = peca.getPlayerMoney();
            System.out.println("O jogador recebeu $" + valor + ". Novo saldo: $" + dinheiroAtual);

        }

    }
}
