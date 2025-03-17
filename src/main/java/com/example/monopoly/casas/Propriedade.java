package com.example.monopoly.casas;

import com.example.monopoly.Player;

import java.util.Scanner;

public class Propriedade extends Casa {
    private String grupo;
    private int preco;
    private int aluguel;

    public Propriedade(int posicao, String nome, String grupo, int preco, int aluguel) {
        super(posicao, nome);
        this.grupo = grupo;
        this.preco = preco;
        this.aluguel = aluguel;
    }

    public String getGrupo() {
        return grupo;
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public int getAluguel() {
        return aluguel;
    }

    public void setAluguel(int aluguel) {
        this.aluguel = aluguel;
    }

    @Override
    public void oferecerCompra(Player jogador) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("A título da propriedade " + getName() + " está disponível por $" + getPreco() + ".");
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
            jogador.comprarPropriedade(this);
        } else {
            System.out.println(jogador.getName() + ", você não tem dinheiro suficiente para comprar esta propriedade.");
        }
    }

    @Override
    public void executarAcao(Player player) {
        System.out.println(" e o peão avançou para " + getPosicao() + " – " + getName());

        if (getProprietario() != null) {
            System.out.println("A propriedade " + getName() + " já possui proprietário.");

            int taxa = getAluguel();

            player.diminuirDinheiro(taxa);
            getProprietario().aumentarDinheiro(taxa);

            System.out.println("O jogador " + player.getName() + " pagou o aluguel de $" + taxa +
                    " para " + getProprietario().getName());
            System.out.println("Novo saldo: $" + player.getPlayerMoney());

        } else {
            oferecerCompra(player);
        }
    }
}
