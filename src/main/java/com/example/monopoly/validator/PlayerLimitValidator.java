package com.example.monopoly.validator;

public class PlayerLimitValidator implements PlayerCountValidator {
    @Override
    public void validate(int numPlayers) {
        if (numPlayers < 2 || numPlayers > 8) {
            throw new IllegalArgumentException("Invalid number of players");
        }
    }
}
