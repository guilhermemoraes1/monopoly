package com.example.monopoly.casas;

import com.example.monopoly.Player;

import java.util.Scanner;

public class Ferrovia extends Casa {
    private int preco;
    private int corrida;

    public Ferrovia(int posicao, String nome, int preco, int corrida) {
        super(posicao, nome);
        this.preco = preco;
        this.corrida = corrida;

    }
    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public int getCorrida() {
        return corrida;
    }

    public void setCorrida(int corrida) {
        this.corrida = corrida;
    }

    @Override
    public void oferecerCompra(Player jogador) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("A título da ferrovia " + getName() + " está disponível por $" + getPreco() + ".");
        System.out.println(jogador.getName() + ", você possui $" + jogador.getPlayerMoney() + ".");

        System.out.print("Você deseja comprar " + getName() +  " (Sim/Não)? ");
        String resposta = scanner.nextLine();
        if (resposta.equalsIgnoreCase("Sim")) {
            venderPara(jogador);
        }
        

    }

    @Override
    public void venderPara(Player jogador) {
        if (jogador.getPlayerMoney() >= getPreco()) {
            jogador.comprarFerrovia(this);
        } else {
            System.out.println(jogador.getName() + ", você não tem dinheiro suficiente para comprar esta ferrovia.");
        }
    }

    @Override
    public void executarAcao(Player player) {
        System.out.println(" e o peão avançou para " + getPosicao() + " – " + getName());

        if (getProprietario() != null) {
            System.out.println("A ferrovia " + getName() + " já possui proprietário.");

            int taxa = getCorrida();

            player.diminuirDinheiro(taxa);
            player.aumentarDinheiro(taxa);

            System.out.println("O jogador " + player.getName() + " pagou o aluguel de $" + taxa +
                    " para " + player.getName());
            System.out.println("Novo saldo: $" + player.getPlayerMoney());

        } else {
            oferecerCompra(player);
        }
    }

}
