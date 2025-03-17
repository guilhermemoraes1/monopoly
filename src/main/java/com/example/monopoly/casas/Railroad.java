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
    public void offerToBuy(Player player) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("A título da ferrovia " + getName() + " está disponível por $" + getPrice() + ".");
        System.out.println(player.getName() + ", você possui $" + player.getPlayerMoney() + ".");

        System.out.print("Você deseja comprar " + getName() +  " (Sim/Não)? ");
        String resposta = scanner.nextLine();
        if (resposta.equalsIgnoreCase("Sim")) {
            sellTo(player);
        }
        

    }

    @Override
    public void sellTo(Player player) {
        if (player.getPlayerMoney() >= getPrice()) {
            player.comprarRailroad(this);
        } else {
            System.out.println(player.getName() + ", você não tem dinheiro suficiente para comprar esta ferrovia.");
        }
    }

    @Override
    public void executarAcao(Player player) {
        System.out.println(" e o peão avançou para " + getPosition() + " – " + getName());

        if (getProprietario() != null) {
            System.out.println("A ferrovia " + getName() + " já possui proprietário.");

            int fine = getRace();

            player.decreaseMoney(fine);
            player.increaseMoney(fine);

            System.out.println("O player " + player.getName() + " pagou o rent de $" + fine +
                    " para " + player.getName());
            System.out.println("Novo saldo: $" + player.getPlayerMoney());

        } else {
            offerToBuy(player);
        }
    }

}
