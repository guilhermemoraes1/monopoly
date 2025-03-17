package com.example.monopoly.casas;

import com.example.monopoly.Player;

import java.util.Scanner;

public class Railroad extends Casa {
    private int price;
    private int race;

    public Railroad(int position, String name, int price, int race) {
        super(position, name);
        this.price = price;
        this.race = race;

    }
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRace() {
        return race;
    }

    public void setRace(int race) {
        this.race = race;
    }

    @Override
    public void oferecerCompra(Player jogador) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("A título da ferrovia " + getName() + " está disponível por $" + getPrice() + ".");
        System.out.println(jogador.getName() + ", você possui $" + jogador.getPlayerMoney() + ".");

        System.out.print("Você deseja comprar " + getName() +  " (Sim/Não)? ");
        String resposta = scanner.nextLine();
        if (resposta.equalsIgnoreCase("Sim")) {
            venderPara(jogador);
        }
        

    }

    @Override
    public void venderPara(Player jogador) {
        if (jogador.getPlayerMoney() >= getPrice()) {
            jogador.comprarRailroad(this);
        } else {
            System.out.println(jogador.getName() + ", você não tem dinheiro suficiente para comprar esta ferrovia.");
        }
    }

    @Override
    public void executarAcao(Player player) {
        System.out.println(" e o peão avançou para " + getPosition() + " – " + getName());

        if (getProprietario() != null) {
            System.out.println("A ferrovia " + getName() + " já possui proprietário.");

            int taxa = getRace();

            player.diminuirDinheiro(taxa);
            player.aumentarDinheiro(taxa);

            System.out.println("O jogador " + player.getName() + " pagou o rent de $" + taxa +
                    " para " + player.getName());
            System.out.println("Novo saldo: $" + player.getPlayerMoney());

        } else {
            oferecerCompra(player);
        }
    }

}
