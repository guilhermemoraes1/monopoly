package com.example.monopoly;

import java.util.Set;

import com.example.monopoly.validator.GameValidator;
import com.example.monopoly.validator.PlayerNameValidator;
import com.example.monopoly.validator.PlayerLimitValidator;
import com.example.monopoly.validator.TokenColorValidator;

public class MonopolyFacade {
    
    private MonopolyGame monopolyGame;
    private Board board;

    public MonopolyFacade() {
        this.board = new Board();
        GameValidator gameValidator = new GameValidator(
            new PlayerNameValidator(),
            new TokenColorValidator(new Color()),
            new PlayerLimitValidator()
        );
        this.monopolyGame = new MonopolyGame(gameValidator);
    }

    public void createGame(int numPlayers, String playerNames, String tokenColors) {
        monopolyGame.createGame(numPlayers, playerNames, tokenColors);
    }

    public int getNumberOfPlayers() {
        return monopolyGame.getNumberOfPlayers();
    }

    public PlayerManager getPlayerManager() {
        return monopolyGame.getPlayerManager();
    }

    public String getPlayerToken(String playerName) {
        Player player = getPlayerManager().findPlayerByName(playerName);
        return player.getPlayerToken();
    }

    public int getPlayerMoney(String playerName) {
        Player player = getPlayerManager().findPlayerByName(playerName);
        return player.getPlayerMoney();
    }

    public int getPlayerPosition(String playerName) {
        Player player = getPlayerManager().findPlayerByName(playerName);
        return player.getPlayerPosition();
    }

    public String getPlayerDeeds(String playerName) {
        Player player = getPlayerManager().findPlayerByName(playerName);
        return player.getPlayerDeeds().isEmpty() ? "{}" : player.getPlayerDeeds().toString();
    }

    public String getCurrentPlayer() {
        Player player = getPlayerManager().getCurrentPlayer();
        return player.getName();
    }

    public String getCommands() {
        Set<String> commands = monopolyGame.getCommands();
        // formatação: {roll,status,quit}
        return "{" + String.join(",", commands) + "}";
    }

    public String getPlaceName(int placeID) {
        return board.getPlaceName(placeID);
    }

    public String getPlaceGroup(int placeID) {
        return board.getPlaceGroup(placeID);
    }

    public String getPlaceOwner(int placeID) {
        return board.getPlaceOwner(placeID);
    }

    public int getPlacePrice(int placeID) {
        return board.getPlacePrice(placeID);
    }

    public int getPropertyRent(int placeID) {
        return board.getPropertyRent(placeID);
    }

    public void quitGame() {
        monopolyGame.quitGame();
    }
}
