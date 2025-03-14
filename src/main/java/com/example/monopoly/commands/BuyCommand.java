package com.example.monopoly.commands;

import com.example.monopoly.MonopolyGame;
import com.example.monopoly.Player;
import com.example.monopoly.Place;
import com.example.monopoly.GameController;

public class BuyCommand implements Command {

    private GameController gameController;

    @Override
    public void execute(MonopolyGame game, Player player) {
        System.out.println("Em BuyCommand" + player.getName() + "está tentando comprar algo.");
        this.gameController = game.getGameController();  // Acessa o GameController através do jogo.

        int currentPosition = player.getPlayerPosition();
        Place place = gameController.getBoard().getPlace(currentPosition);  // Usa o Board do GameController.

        if (place.getOwner() == null) {
            int price = place.getPrice();

            if (player.getPlayerMoney() >= price) {
                gameController.buyProperty(player, place);  // Compra a propriedade.
                player.addDeed(place.getName());  // Adiciona a propriedade ao conjunto de deeds do jogador.
                System.out.println(player.getName() + " comprou " + place.getName() + " por " + price + "!");
            } else {
                System.out.println(player.getName() + " não tem dinheiro suficiente para comprar " + place.getName());
            }
        } else {
            System.out.println(place.getName() + " já tem um proprietário.");
        }
    }
}
