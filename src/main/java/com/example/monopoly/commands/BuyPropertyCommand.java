package com.example.monopoly.commands;

import com.example.monopoly.MonopolyGame;
import com.example.monopoly.Player;
import com.example.monopoly.Board;
import com.example.monopoly.Place;

public class BuyPropertyCommand implements Command {

    @Override
    public void execute(MonopolyGame game, Player currentPlayer) {
        Board board = game.getGameController().getBoard();
        Place currentPlace = board.getPlace(currentPlayer.getPlayerPosition());

        // Verificando se o jogador tem dinheiro suficiente para comprar
        if (currentPlayer.getPlayerMoney() >= currentPlace.getPrice() ) {
            // O jogador compra a propriedade
            currentPlayer.setPlayerMoney(currentPlayer.getPlayerMoney() - currentPlace.getPrice());  // Decrementa o dinheiro do jogador
            currentPlace.setOwner(currentPlayer.getName());  // Define o novo dono da propriedade

            // Adiciona a propriedade ao conjunto de "deeds" do jogador
            currentPlayer.addDeed(currentPlace.getName()); 

            System.out.println(currentPlayer.getName() + " bought " + currentPlace.getName());
        } else {
            System.out.println(currentPlayer.getName() + " cannot afford " + currentPlace.getName());
        }
    }
}
