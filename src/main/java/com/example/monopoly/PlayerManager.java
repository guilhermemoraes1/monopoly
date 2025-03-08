package com.example.monopoly;

import java.util.ArrayList;
import java.util.List;

public class PlayerManager {
    private List<Player> players;
    private int currentPlayerIndex;

    public PlayerManager() {
        this.players = new ArrayList<>();
        this.currentPlayerIndex = 0;
    }

    public void createPlayers(int numPlayers, String playerNames, String tokenColors) {
        if (playerNames.charAt(0) == '{') {
            playerNames = playerNames.substring(1, playerNames.length() - 1);
        }
        if (tokenColors.charAt(0) == '{') {
            tokenColors = tokenColors.substring(1, tokenColors.length() - 1);
        }
    

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

    public List<Player> getPlayers() {
        return players;
    }

    public Player getCurrentPlayer() {
        return players.get(currentPlayerIndex);
    }
}
