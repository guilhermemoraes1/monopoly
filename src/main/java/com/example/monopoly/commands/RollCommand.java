package com.example.monopoly.commands;

import com.example.monopoly.Board;
import com.example.monopoly.MonopolyGame;
import com.example.monopoly.Player;
import com.example.monopoly.PlayerManager;
import com.example.monopoly.places.Place;

public class RollCommand implements Command {
    private PlayerManager playerManager;

    @Override
    public void execute(MonopolyGame game, Player player) {

        System.out.println(player.getName() + " rolled the dice!");
        int firstDieResult = (int) (Math.random() * 6) + 1; 
        int secondDieResult = (int) (Math.random() * 6) + 1; 

        validateDiceResults(firstDieResult, secondDieResult);

        int diceSum = firstDieResult + secondDieResult;
        System.out.println(player.getName() + " rolled a " + firstDieResult + " and a " + secondDieResult + " for a total of " + diceSum);

        player.mover(diceSum);

        int newPosition = player.getPlayerPosition();
        if (newPosition > 40) {
            newPosition -= 40;
        }

        Board board = game.getBoard();
        Place currentPlace = board.getPlaceInPosition(newPosition);
        currentPlace.executarAcao(player);
        if (player.bankruptcy(player)) {
            System.out.println("The player " + player.getName() + " lost all the money and died");
            PlayerManager playerManager = game.getPlayerManager();
            playerManager.removePlayer(player.getName());
            int numPlayers = playerManager.getPlayers().size();

            if (numPlayers == 1) {
                System.out.println("Parabéns! O jogador " + playerManager.getPlayers() + " venceu!");
                game.quitGame();

            } else {
                System.out.println("Continue the game with " + numPlayers + " player left.\n");
            }
        }
        game.nextTurn();

    }

    private void validateDiceResults(int firstDieResult, int secondDieResult) {
        if (firstDieResult <= 0 || firstDieResult > 6 || secondDieResult <= 0 || secondDieResult > 6) {
            throw new IllegalArgumentException("Invalid die result");
        }
    }

    @Override
    public void execute(Player player) {
        int dice1 = (int) (Math.random() * 6) + 1; 
        int dice2 = (int) (Math.random() * 6) + 1; 

        System.out.println("\nThe player " + player.getName() + " had " + dice1 + "," + dice2);

        if (dice1 == dice2) {

            System.out.println("You left the jail!\n");
            player.resetarJogadas();

        } else {
            System.out.println("You weren't able to leave the jail.\n");
            player.incrementarJogadas();
        }

    }
}
