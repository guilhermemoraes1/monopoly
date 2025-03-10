package com.example.monopoly;

import java.util.List;
import java.util.Set;

import com.example.monopoly.validator.GameValidator;
import com.example.monopoly.validator.WordUtils;

public class MonopolyGame {
    private final PlayerManager playerManager;
    private final GameController gameController;
    private final GameValidator gameValidator;
    
    private boolean isGameOn;
    private int numPlayers;
    private int currentPlayerIndex;

    public MonopolyGame(GameValidator gameValidator) {
        this.gameValidator = gameValidator; 
        this.playerManager = new PlayerManager();
        this.gameController = new GameController();
        this.isGameOn = false;
        this.currentPlayerIndex = 0;
    }

    public void createGame(int numPlayers, String playerNames, String tokenColors) {
        playerNames = WordUtils.hasCurlyBraces(playerNames);
        tokenColors = WordUtils.hasCurlyBraces(tokenColors);
        gameValidator.validateGame(numPlayers, playerNames, tokenColors);
        playerManager.createPlayers(numPlayers, playerNames, tokenColors);
        this.numPlayers = numPlayers;
        startGame();
    }

    private void startGame() {
        isGameOn = true;
        System.out.println("Monopoly game started with " + numPlayers + " players!");
    }

    public void quitGame() {
        if (!isGameOn) {
            throw new IllegalArgumentException("There's no game to quit");
        } else {
            isGameOn = false;
            System.out.println("The game has been quit.");
        }
    }

    public Player getCurrentPlayer() {
        return playerManager.getCurrentPlayer();
    }

    public void nextTurn() {
        currentPlayerIndex = (currentPlayerIndex + 1) % numPlayers;
        playerManager.setCurrentPlayerIndex(currentPlayerIndex);
    }
    

    public Set<String> getCommands() {
        return gameController.getCommands().keySet();
    }

    public int getNumberOfPlayers() {
        return numPlayers;
    }

    public List<Player> getPlayers() {
        return playerManager.getPlayers();
    }

    public boolean getIsGameOn() {
        return isGameOn; 
    }

    public PlayerManager getPlayerManager() {
        return playerManager;
    }
}
