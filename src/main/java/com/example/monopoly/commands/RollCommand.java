package com.example.monopoly.commands;

import com.example.monopoly.MonopolyGame;
import com.example.monopoly.Player;

public class RollCommand implements Command {
    @Override
    public void execute(MonopolyGame game, Player player) {
        int firstDieResult = (int) (Math.random() * 6) + 1; 
        int secondDieResult = (int) (Math.random() * 6) + 1; 

        validateDiceResults(firstDieResult, secondDieResult);

        int diceSum = firstDieResult + secondDieResult;
        System.out.println(player.getName() + " rolled a " + firstDieResult + " and a " + secondDieResult + " for a total of " + diceSum);
    }

    public void execute(MonopolyGame game, Player player, int firstDieResult, int secondDieResult) {
        validateDiceResults(firstDieResult, secondDieResult);

        int diceSum = firstDieResult + secondDieResult;
        System.out.println(player.getName() + " rolled a " + firstDieResult + " and a " + secondDieResult + " for a total of " + diceSum);
    }

    private void validateDiceResults(int firstDieResult, int secondDieResult) {
        if (firstDieResult <= 0 || firstDieResult > 6 || secondDieResult <= 0 || secondDieResult > 6) {
            throw new IllegalArgumentException("Invalid die result");
        }
    }
}
