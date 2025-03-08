package com.example.monopoly;

import java.util.Scanner;

public class MonopolyApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        GameInputData gameInputData = new GameInputData();
        MonopolyGame game = gameInputData.configureGame(scanner);
        GameController gameController = new GameController();

        GameInteraction gameInteraction = new GameInteraction(gameController);
        gameInteraction.startGameLoop(game, scanner);
    }
}
