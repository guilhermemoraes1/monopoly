package com.example.monopoly.places;

import com.example.monopoly.Board;
import com.example.monopoly.Player;

import java.util.Scanner;

public class PublicService extends Place{
    private int price;

    public PublicService(int position, String name, int price, Board board) {
        super(position, name, board);
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

        System.out.println("The service title " + getName() + " is available for $" + getPrice() + ".");
        System.out.println(player.getName() + ", you have $" + player.getPlayerMoney() + ".");

        System.out.print("Do you want to buy " + getName() + " (Yes/No)? ");
        String resposta = scanner.nextLine();
        if (resposta.equalsIgnoreCase("yes")) {
            sellTo(player);
        }
        

    }

    @Override
    public void sellTo(Player player) {
        if (player.getPlayerMoney() >= getPrice()) {
            player.buy(this);
        } else {
            System.out.println(player.getName() + ", you don't have enough money to buy this property");
        }
    }

    @Override
    public void executarAcao(Player player) {
        System.out.println("The player advanced to position " + getPosition() + ", place: " + getName());

        if (getOwner() == player ) {
            System.out.println("You are the owner of the place.");;
        } else if (getOwner() != null) {
            System.out.println("The public service " + getName() + " already has an owner.");

            int fine = getPrice();

            player.decreaseMoney(fine);
            getOwner().increaseMoney(fine);

            System.out.println("Player " + player.getName() + " paid rent of $" + fine + " to " + getOwner().getName());
            System.out.println("New Balance: $" + player.getPlayerMoney());

        } else {
            offerToBuy(player);
        }
    }

}
