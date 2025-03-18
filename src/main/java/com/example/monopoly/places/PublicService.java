package com.example.monopoly.places;

import com.example.monopoly.Player;

import java.util.Scanner;

public class PublicService extends Place{
    private int price;

    public PublicService(int position, String name, int price) {
        super(position, name);
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String getGroup() {
        return null;
    };

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public void offerToBuy(Player player) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("O título do serviço " + getName() + " está disponível por $" + getPrice() + ".");
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
        System.out.println(" e o peão avançou para " + player.getPlayerPosition() + " – " + player.getName());

        if (getOwner() != null) {
            System.out.println("O serviço público " + getName() + " já possui proprietário.");

            int fine = getPrice();

            player.decreaseMoney(fine);
            getOwner().increaseMoney(fine);

            System.out.println("O player " + player.getName() + " pagou a fine fixa de $" + fine +
                    " para " + getOwner().getName());
            System.out.println("Novo saldo: $" + player.getPlayerMoney());

        } else {
            offerToBuy(player);
        }
    }

}
