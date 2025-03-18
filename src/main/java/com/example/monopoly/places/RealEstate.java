package com.example.monopoly.places;

import com.example.monopoly.Player;

import java.util.Scanner;

public class RealEstate extends Place {
    private String group;
    private int price;
    private int rent;

    public RealEstate(int position, String name, String group, int price, int rent) {
        super(position, name);
        this.group = group;
        this.price = price;
        this.rent = rent;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String getGroup() {
        return group;
    };

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    @Override
    public void offerToBuy(Player player) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("A título da propriedade " + getName() + " está disponível por $" + getPrice() + ".");
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
            player.buy(this);
        } else {
            System.out.println(player.getName() + ", você não tem dinheiro suficiente para comprar esta propriedade.");
        }
    }

    @Override
    public void executarAcao(Player player) {
        System.out.println(" e o peão avançou para " + getPosition() + " – " + getName());

        if (getOwner() != null) {
            System.out.println("A propriedade " + getName() + " já possui proprietário.");

            int fine = getRent();

            player.decreaseMoney(fine);
            getOwner().increaseMoney(fine);

            System.out.println("O player " + player.getName() + " pagou o rent de $" + fine +
                    " para " + getOwner().getName());
            System.out.println("Novo saldo: $" + player.getPlayerMoney());

        } else {
            offerToBuy(player);
        }
    }
}
