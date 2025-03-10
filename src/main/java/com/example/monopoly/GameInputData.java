package com.example.monopoly;

import com.example.monopoly.validator.GameValidator;
import com.example.monopoly.validator.PlayerLimitValidator;
import com.example.monopoly.validator.PlayerNameValidator;
import com.example.monopoly.validator.TokenColorValidator;
import java.util.Scanner;

public class GameInputData {

    private final GameValidator gameValidator;
    private Color colorValidator;

    public GameInputData() {
        this.colorValidator = new Color();
        PlayerLimitValidator playerLimitValidator = new PlayerLimitValidator();
        PlayerNameValidator playerNameValidator = new PlayerNameValidator();

        this.gameValidator = new GameValidator(
            playerNameValidator,
            new TokenColorValidator(colorValidator),
            playerLimitValidator
        );
    }

    public MonopolyGame configureGame(Scanner scanner) {
        System.out.print("Enter the number of players [2-8]: ");
        int numPlayers = scanner.nextInt();
        scanner.nextLine();

        StringBuilder playerNames = new StringBuilder();
        StringBuilder tokenColors = new StringBuilder();

        for (int i = 1; i <= numPlayers; i++) {
            System.out.print("Enter the name of player " + i + ": ");
            String name = scanner.nextLine();
            playerNames.append(name).append(", ");

            System.out.println("Choose the token color for player " + i + " from the following options:");
            // posso deixar dinâmico
            System.out.println("[black] [white] [red] [green] [blue] [yellow] [orange] [pink]");
            String color = scanner.nextLine();

            while (!colorValidator.isValidColor(color)) {
                System.out.println("Invalid color. Please choose a valid color from the options:");
                color = scanner.nextLine();
            }

            tokenColors.append(color).append(", ");
        }

        playerNames.setLength(playerNames.length() - 2);
        tokenColors.setLength(tokenColors.length() - 2);

        MonopolyGame game = new MonopolyGame(gameValidator);
        game.createGame(numPlayers, playerNames.toString(), tokenColors.toString());

        return game;
    }
}
