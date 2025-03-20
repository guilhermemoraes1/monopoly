package com.example.monopoly.places;

import com.example.monopoly.Board;
import com.example.monopoly.Player;

import java.util.Scanner;

public class Railroad extends Place {
    private int price;
    private int race;

    public Railroad(int position, String name, int price, int race, Board board) {
        super(position, name, board);
        this.price = price;
        this.race = race;
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

    public int getRace() {
        return race;
    }

    public void setRace(int race) {
        this.race = race;
    }

    @Override
    public void offerToBuy(Player player) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("The railroad title " + getName() + " is available by $" + getPrice() + ".");
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
            System.out.println(player.getName() + ", you don't have enough money to buy this railroad.");
        }
    }

    @Override
    public void executarAcao(Player player) {
        System.out.println("The player advanced to position " + getPosition() + ", place: " + getName());

        if (getOwner() == player ) {
            System.out.println("You are the owner of the place.");;
        } else if (getOwner() != null) {
            System.out.println("The railway " + getName() + " already has an owner.");

            int fine = getRace();

            player.decreaseMoney(fine);
            player.increaseMoney(fine);

            System.out.println("Player " + player.getName() + " paid rent of $" + fine + " to " + player.getName());
            System.out.println("New Balance: $" + player.getPlayerMoney());

        } else {
            offerToBuy(player);
        }
    }

}
