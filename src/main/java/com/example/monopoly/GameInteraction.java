    package com.example.monopoly;

    import java.util.Scanner;

    public class GameInteraction {
        private final GameController gameController;

        public GameInteraction(GameController gameController) {
            this.gameController = gameController;
        }

        public void startGameLoop(MonopolyGame game, Scanner scanner) {
            while (game.getIsGameOn()) {
                gameController.printPlayerMenu(game);

                System.out.print("Enter command: ");
                String command = scanner.nextLine().toLowerCase();

                gameController.processCommand(command, game);
            }
        }
    }
