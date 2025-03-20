package com.example.monopoly.places;

import com.example.monopoly.Board;
import com.example.monopoly.Player;

import java.util.Scanner;

public class RealEstate extends Place {
    private String group;
    private int price;
    private int rent;

    public RealEstate(int position, String name, String group, int price, int rent, Board board) {
        super(position, name, board);
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

        System.out.println("The property title " + getName() + " is available by $" + getPrice() + ".");
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
            System.out.println(player.getName() + ", you don't have enough money to buy this property.");
        }
    }

    @Override
    public void executarAcao(Player player) {
        System.out.println("The player advanced to position " + getPosition() + ", place: " + getName());

        if (getOwner() == player ) {
            System.out.println("You are the owner of the place.");;
        } else if (getOwner() != null) {
            System.out.println("Property " + getName() + " already has an owner.");

            int rent = getRent();

            player.decreaseMoney(rent);
            getOwner().increaseMoney(rent);

            System.out.println("The player " + player.getName() + " paid the rent of $" + rent +
                    " to " + getOwner().getName());
            System.out.println("New Balance: $" + player.getPlayerMoney());

        } else {
            offerToBuy(player);
        }
    }
}
