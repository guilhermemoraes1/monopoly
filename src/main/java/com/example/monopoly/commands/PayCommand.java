package com.example.monopoly.commands;

import com.example.monopoly.MonopolyGame;
import com.example.monopoly.Player;

public class PayCommand implements Command {
    @Override
    public void execute(MonopolyGame game, Player player) {}

    @Override
    public void execute(Player player) {
        int fineValue = 50;

        if (player.getPlayerMoney() >= fineValue) {
            System.out.println("You paid the leave the jail! New Balance: $" + player.getPlayerMoney());
            player.decreaseMoney(fineValue);

            player.resetarJogadas();
        } else {
            System.out.println("You don't enough money to pay the fine");
        }
    }

}