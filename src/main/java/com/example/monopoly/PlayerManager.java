package com.example.monopoly;

import java.util.ArrayList;
import java.util.List;

import com.example.monopoly.validator.WordUtils;

public class PlayerManager {
    private List<Player> players;
    private int currentPlayerIndex;

    public PlayerManager() {
        this.players = new ArrayList<>();
    }

    public void createPlayers(int numPlayers, String playerNames, String tokenColors) {
        playerNames = WordUtils.hasCurlyBraces(playerNames);
        tokenColors = WordUtils.hasCurlyBraces(tokenColors);

        String[] names = playerNames.split(",");
        String[] colors = tokenColors.split(",");

        for (int i = 0; i < numPlayers; i++) {
            String name = names[i].trim();
            String color = colors[i].trim();
            Player player = new Player(name, color);
            players.add(player);
        }
    }

    public Player findPlayerByName(String name) {
        for (Player player : getPlayers()) {
            if (player.getName().equals(name)) {
                return player; 
            }
        }
        throw new IllegalArgumentException("Player doesn't exist");
    }

    public void setCurrentPlayerIndex(int index) {
        this.currentPlayerIndex = index;
    }    

    public List<Player> getPlayers() {
        return players;
    }

    public Player getCurrentPlayer() {
        return players.get(currentPlayerIndex);
    }
}
