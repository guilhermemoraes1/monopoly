package com.example.monopoly.validator;

public class GameValidator {

    private final Validator playerNameValidator;
    private final Validator tokenColorValidator;
    private final PlayerCountValidator playerLimitValidator;

    public GameValidator(Validator playerNameValidator, Validator tokenColorValidator, PlayerCountValidator playerLimitValidator) {
        this.playerNameValidator = playerNameValidator;
        this.tokenColorValidator = tokenColorValidator;
        this.playerLimitValidator = playerLimitValidator;
    }
 
    public void validateGame(int numPlayers, String playerNames, String tokenColors) {
        playerLimitValidator.validate(numPlayers);
        playerNameValidator.validate(numPlayers, playerNames);
        tokenColorValidator.validate(numPlayers, tokenColors);
        
    }
}

