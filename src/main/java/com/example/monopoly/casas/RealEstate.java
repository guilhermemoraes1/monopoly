package com.example.monopoly.casas;

import com.example.monopoly.Player;

import java.util.Scanner;

public class RealEstate extends Casa {
    private String grupo;
    private int price;
    private int rent;

    public RealEstate(int position, String name, String grupo, int price, int rent) {
        super(position, name);
        this.grupo = grupo;
        this.price = price;
        this.rent = rent;
    }

    public String getGrupo() {
        return grupo;
    }

    public int getPrice() {
        return price;
    }

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
            player.comprarRealEstate(this);
        } else {
            System.out.println(player.getName() + ", você não tem dinheiro suficiente para comprar esta propriedade.");
        }
    }

    @Override
    public void executarAcao(Player player) {
        System.out.println(" e o peão avançou para " + getPosition() + " – " + getName());

        if (getProprietario() != null) {
            System.out.println("A propriedade " + getName() + " já possui proprietário.");

            int fine = getRent();

            player.decreaseMoney(fine);
            getProprietario().increaseMoney(fine);

            System.out.println("O player " + player.getName() + " pagou o rent de $" + fine +
                    " para " + getProprietario().getName());
            System.out.println("Novo saldo: $" + player.getPlayerMoney());

        } else {
            offerToBuy(player);
        }
    }
}
