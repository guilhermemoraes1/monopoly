package com.example.monopoly;

import com.example.monopoly.commands.*;

import java.util.Map;
import java.util.LinkedHashMap;

public class GameController {
    private final Map<String, Command> commands = new LinkedHashMap<>();
    private Board board;
    private boolean automaticBuying = false;

    public GameController() {
        this.board = new Board();
        commands.put("roll", new RollCommand());
        commands.put("status", new StatusCommand());
        commands.put("quit", new QuitCommand());
        commands.put("buy", new BuyCommand());
    }

    public Board getBoard() {
        return board; 
    }

    public void setAutomaticBuying(boolean auto) {
        this.automaticBuying = auto;
    }

    public boolean isAutomaticBuying() {
        return automaticBuying;
    }

    public void processCommand(String command, MonopolyGame game) {
        Player currentPlayer = game.getCurrentPlayer();
        Command cmd = commands.get(command);
        if (cmd != null) {
            cmd.execute(game, currentPlayer);
        } else {
            System.out.println("Comando inválido. Tente novamente.");
        }
    }

    public Map<String, Command> getCommands() {
        return commands;
    }

    public void buyProperty(Player player, Place place) {
        System.out.println(player.getName() + "está tentando comprar algo!!!");
        if (place.getOwner() == null && player.getPlayerMoney() >= place.getPrice()) {
            player.setMoney(player.getPlayerMoney() - place.getPrice());// Deduz o preço da propriedade do saldo do jogador
            place.setOwner(player.getName()); // Define o jogador como o proprietário
            player.addDeed(place.getName()); // Adiciona o nome da propriedade à lista de deeds do jogador
        } else {
            System.out.println(player.getName() + " não tem dinheiro suficiente para comprar " + place.getName());
        }
    }

    public void processPlayerTurn(MonopolyGame game) {
        Player currentPlayer = game.getCurrentPlayer();
        // System.out.println("Processando turno para: " + currentPlayer.getName());
        Place currentPlace = board.getPlace(currentPlayer.getPlayerPosition());
        System.out.println("Jogador está na propriedade: " + currentPlace.getName());
    
        // Se a compra automática estiver ativada e a propriedade não tem dono, compra automaticamente
        if (isAutomaticBuying() && currentPlace.getOwner() == null && currentPlayer.getPlayerMoney() >= currentPlace.getPrice()) {
            System.out.println("A compra automática está sendo executada!");
            buyProperty(currentPlayer, currentPlace);
            System.out.println(currentPlayer.getName() + " comprou automaticamente a propriedade " + currentPlace.getName());
        }
    }
    

    // Método para exibir o menu do jogador
    public void printPlayerMenu(MonopolyGame game) {
        if (!game.getIsGameOn()) {
            System.out.println("O jogo terminou.");
            return;
        }

        Player currentPlayer = game.getCurrentPlayer();
        System.out.println("\nÉ a vez de " + currentPlayer.getName() + ".");
        System.out.println("Comandos disponíveis: " + getCommands().keySet());
    }
}
