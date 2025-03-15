package com.example.monopoly;

import com.example.monopoly.commands.Command;
import com.example.monopoly.commands.QuitCommand;
import com.example.monopoly.commands.RollCommand;
import com.example.monopoly.commands.StatusCommand;
import com.example.monopoly.commands.BuyPropertyCommand;  // Importa o comando de compra

import java.util.Map;
import java.util.LinkedHashMap;

public class GameController {
    private final Map<String, Command> commands = new LinkedHashMap<>();
    private Board board;
    
    public GameController() {
        this.board = new Board();
        commands.put("roll", new RollCommand());
        commands.put("status", new StatusCommand());
        commands.put("quit", new QuitCommand());
        // Não adicionamos "buy" no mapa de comandos para não aparecer para o jogador
    }

    public void processCommand(String command, MonopolyGame game) {
        Player currentPlayer = game.getCurrentPlayer();
        Command cmd = commands.get(command);
        if (cmd != null) {
            cmd.execute(game, currentPlayer);
        } else {
            System.out.println("Invalid command. Try again.");
        }
    }

    public Board getBoard() {
        return board; 
    }

    public Map<String, Command> getCommands() {
        return commands;
    }

    // Método chamado para a jogada do jogador
    public void handleTurn(MonopolyGame game, Place currentPlace) {
        Player currentPlayer = game.getCurrentPlayer();
        
        // Verificar o dono da propriedade
        String owner = currentPlace.getOwner();
    
        // Se o dono for o banco, verifica se o jogador pode comprar a propriedade
        if (owner != null && owner.equals("bank")) {
            // O banco é o dono da propriedade
            if (currentPlayer.getPlayerMoney() >= currentPlace.getPrice()) {
                // Se o jogador tiver dinheiro suficiente, ele compra a propriedade
                new BuyPropertyCommand().execute(game, currentPlayer);
            } else {
                // Se o jogador não tiver dinheiro suficiente, ele paga o aluguel
                int rent = currentPlace.getRent();
                currentPlayer.setPlayerMoney(currentPlayer.getPlayerMoney() - rent);
                // O aluguel vai para o banco, então não há necessidade de uma mudança de proprietário
                System.out.println(currentPlayer.getName() + " pagou " + rent + " de aluguel ao banco.");
            }
        } else if (owner != null && !owner.equals(currentPlayer.getName()) && !owner.equals("bank")) {
            // Se o dono não for o banco e for outro jogador
            int rent = currentPlace.getRent();
            currentPlayer.setPlayerMoney(currentPlayer.getPlayerMoney() - rent);
    
            // Encontra o jogador dono da propriedade
            Player propertyOwner = game.getPlayerManager().findPlayerByName(owner);
            propertyOwner.setPlayerMoney(propertyOwner.getPlayerMoney() + rent);
    
            System.out.println(currentPlayer.getName() + " pagou " + rent + " de aluguel para " + propertyOwner.getName());
        }
    }
    

    public void printPlayerMenu(MonopolyGame game) {
        if (!game.getIsGameOn()) {
            System.out.println("The game has ended.");
            return;
        }
        
        Player currentPlayer = game.getCurrentPlayer();
        System.out.println("\nIt's " + currentPlayer.getName() + "'s turn.");
        System.out.println("Available commands: " + getCommands().keySet());  // Não mostra "buy" aqui
    }
}
