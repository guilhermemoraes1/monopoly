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

    public void removePlayer(Player player) {
        players.remove(player);  // Remove o jogador da lista
        System.out.println(player.getName() + " foi removido do jogo.");
    }

    public Player findPlayerByName(String name) {
        for (int i = 0; i < getPlayers().size(); i++) {
            Player player = getPlayers().get(i);
            if (player.getName().equals(name)) {
                // Verifica se o jogador falhou
                if (player.getPlayerMoney() < 0) {
                    getPlayers().remove(i);  // Remove o jogador da lista
                    throw new IllegalArgumentException("Player no longer in the game");
                }
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
