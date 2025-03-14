package com.example.monopoly.commands;

import com.example.monopoly.Board;
import com.example.monopoly.MonopolyGame;
import com.example.monopoly.Place;
import com.example.monopoly.Player;


public class RollCommand implements Command {

    @Override
    public void execute(MonopolyGame game, Player player) {
        if 
        int firstDieResult = (int) (Math.random() * 6) + 1; 
        int secondDieResult = (int) (Math.random() * 6) + 1; 

        validateDiceResults(firstDieResult, secondDieResult);

        int diceSum = firstDieResult + secondDieResult;
        System.out.println(player.getName() + " rolled a " + firstDieResult + " and a " + secondDieResult + " for a total of " + diceSum);

        updatePlayerPosition(game, player, diceSum);
    }

    public void rollDice(MonopolyGame game, int firstDieResult, int secondDieResult) {
        validateDiceResults(firstDieResult, secondDieResult);

        int diceSum = firstDieResult + secondDieResult;
        Player player = game.getCurrentPlayer();
        // System.out.println(player.getName() + " rolled a " + firstDieResult + " and a " + secondDieResult + " for a total of " + diceSum);

        updatePlayerPosition(game, player, diceSum);
        game.nextTurn();
    }

    private void validateDiceResults(int firstDieResult, int secondDieResult) {
        if (firstDieResult <= 0 || firstDieResult > 6 || secondDieResult <= 0 || secondDieResult > 6) {
            throw new IllegalArgumentException("Invalid die result");
        }
    }

    private void updatePlayerPosition(MonopolyGame game, Player player, int diceSum) {
        int newPosition = player.getPlayerPosition() + diceSum;
        boolean passedGo = false;
    
        if (newPosition > 40) {
            newPosition -= 40; // Volta para a posição inicial, após passar pela casa GO
            passedGo = true;
        }
    
        player.setPosition(newPosition);
        Board board = game.getGameController().getBoard();
        Place currentPlace = board.getPlace(newPosition);
        System.out.println(player.getName() + " agora está na posição " + currentPlace.getName());
    
        // Verifica se o jogador passou pela casa GO
        if (passedGo) {
            System.out.println(player.getName() + " passou pela casa GO e recebeu $200!");
            player.setMoney(player.getPlayerMoney() + 200); // Ganha $200 por passar em GO
        }
    
        // Verifica se o jogador caiu na casa 0 (GO), mas não paga o dinheiro duas vezes
        if (newPosition == 0 && !passedGo) {
            System.out.println(player.getName() + " caiu na casa GO e recebeu $200!");
            player.setMoney(player.getPlayerMoney() + 200);
        }
    
        if (currentPlace.getName().equals("Luxury Tax")) {
            System.out.println(player.getName() + " caiu no Imposto de Riqueza e pagou $75 ao banco.");
            player.setMoney(player.getPlayerMoney() - 75); // Deduz $75 do jogador
        }
    
        if (currentPlace.getName().equals("Income Tax")) {
            System.out.println(player.getName() + " caiu no Imposto de Renda e pagou $200 ao banco.");
            player.setMoney(player.getPlayerMoney() - 200); // Subtrai $200 do jogador
        }
    
        // Verifica se o jogador caiu em uma propriedade com dono
        if (currentPlace.getOwner() != null && !currentPlace.getOwner().equals(player.getName())) {
            // Caso o jogador caia em uma propriedade com dono, paga o aluguel
            int rent = currentPlace.getRent();
            String ownerName = currentPlace.getOwner();
    
            if (isOwnerPlayer(ownerName, game)) {
                // Se o proprietário for um jogador
                Player owner = game.getPlayerManager().findPlayerByName(ownerName);
                if (player.getPlayerMoney() >= rent) {
                    // Subtrai o valor do aluguel do jogador e adiciona ao dono
                    player.setMoney(player.getPlayerMoney() - rent);
                    owner.setMoney(owner.getPlayerMoney() + rent);
                    System.out.println(player.getName() + " pagou $" + rent + " de aluguel para " + owner.getName());
                } else {
                    // Se o jogador não tem dinheiro suficiente
                    System.out.println(player.getName() + " não tem dinheiro suficiente para pagar o aluguel de " + currentPlace.getName());
                }
            } else {
                // Se o proprietário for o banco ou outra entidade que não seja um jogador
                System.out.println(player.getName() + " perdeu $" + rent + " de aluguel para o banco.");
                player.setMoney(player.getPlayerMoney() - rent);  // O jogador perde o dinheiro, mas não há pagamento a um dono
            }
        }
    
        // Lógica para serviços públicos e ferrovias, considerando o dono ser um jogador ou o banco
        handleSpecialPropertyRent(currentPlace, player, diceSum, game);
    }
    
    // Método auxiliar para verificar se o proprietário é um jogador
    private boolean isOwnerPlayer(String ownerName, MonopolyGame game) {
        try {
            game.getPlayerManager().findPlayerByName(ownerName); // Tenta encontrar o proprietário como um jogador
            return true;
        } catch (IllegalArgumentException e) {
            return false; // Se não encontrar, assume que o proprietário não é um jogador (possivelmente o banco)
        }
    }
    
    private void handleSpecialPropertyRent(Place currentPlace, Player player, int diceSum, MonopolyGame game) {
        Board board = game.getGameController().getBoard();

        int utilityRent = 0;  // Definindo as variáveis para o aluguel
        int railroadRent = 0;
        // Verifica se o jogador caiu em um serviço público
        if (currentPlace.getGroup().equals("utilities") && currentPlace.getOwner() != null && !currentPlace.getOwner().equals(player.getName())) {
            String ownerName = currentPlace.getOwner();
            if (isOwnerPlayer(ownerName, game)) {
                Player owner = game.getPlayerManager().findPlayerByName(ownerName);
                int utilitiesOwned = countOwnedUtilities(owner, board);
                utilityRent = calculateUtilityRent(utilitiesOwned, diceSum);
                handleRentPayment(player, owner, utilityRent, "serviço público");
            } else {
                // Se o proprietário for o banco
                System.out.println(player.getName() + " perdeu $" + utilityRent + " de aluguel do serviço público para o banco.");
                player.setMoney(player.getPlayerMoney() - utilityRent);  // O jogador perde o dinheiro, sem pagamento ao banco
            }
        }
    
        // Verifica se o jogador caiu em uma ferrovia
        if (currentPlace.getGroup().equals("railroad") && currentPlace.getOwner() != null && !currentPlace.getOwner().equals(player.getName())) {
            String ownerName = currentPlace.getOwner();
            if (isOwnerPlayer(ownerName, game)) {
                Player owner = game.getPlayerManager().findPlayerByName(ownerName);
                int railroadsOwned = countOwnedRailroads(owner, board);
                railroadRent = calculateRailroadRent(railroadsOwned);
                handleRentPayment(player, owner, railroadRent, "ferrovia");
            } else {
                // Se o proprietário for o banco
                System.out.println(player.getName() + " perdeu $" + railroadRent + " de aluguel da ferrovia para o banco.");
                player.setMoney(player.getPlayerMoney() - railroadRent);  // O jogador perde o dinheiro, sem pagamento ao banco
            }
        }

        if (player.getPlayerMoney() < 0) {
            handleBankruptcy(player, game); // O jogador entra em falência
        } 
    }

    // Método para lidar com a falência do jogador
    private void handleBankruptcy(Player player, MonopolyGame game) {
        System.out.println(player.getName() + " entrou em falência!");
        Board board = game.getGameController().getBoard();

        // O jogador perde todos os seus pertences e propriedades
        Place[] ownedPlaces = board.getPlaces().values().stream()
                .filter(place -> place.getOwner() != null && place.getOwner().equals(player.getName()))
                .toArray(Place[]::new);

        for (Place place : ownedPlaces) {
            // Retorna a propriedade ao banco
            place.setOwner(null);
            System.out.println(player.getName() + " perdeu a propriedade " + place.getName() + " para o banco.");
        }

        // Remover o jogador da lista de jogadores ativos
        game.getPlayerManager().removePlayer(player);
        System.out.println(player.getName() + " foi removido do jogo.");
    }

    
    private int countOwnedUtilities(Player owner, Board board) {
        int utilitiesOwned = 0;
        for (Place place : board.getPlaces().values()) {
            if (place.getGroup().equals("utilities") && place.getOwner() != null && place.getOwner().equals(owner.getName())) {
                utilitiesOwned++;
            }
        }
        return utilitiesOwned;
    }
    
    private int calculateUtilityRent(int utilitiesOwned, int diceSum) {
        if (utilitiesOwned == 1) {
            return 4 * diceSum;  // 4 vezes o valor do dado
        } else if (utilitiesOwned == 2) {
            return 10 * diceSum; // 10 vezes o valor do dado
        }
        return 0;
    }
    
    private int countOwnedRailroads(Player owner, Board board) {
        int railroadsOwned = 0;
        for (Place place : board.getPlaces().values()) {
            if (place.getGroup().equals("railroad") && place.getOwner() != null && place.getOwner().equals(owner.getName())) {
                railroadsOwned++;
            }
        }
        return railroadsOwned;
    }
    
    private int calculateRailroadRent(int railroadsOwned) {
        switch (railroadsOwned) {
            case 1:
                return 25;
            case 2:
                return 50;
            case 3:
                return 75;
            case 4:
                return 100;
            default:
                return 0;
        }
    }
    
    private void handleRentPayment(Player player, Player owner, int rent, String propertyType) {
        if (player.getPlayerMoney() >= rent) {
            player.setMoney(player.getPlayerMoney() - rent);
            owner.setMoney(owner.getPlayerMoney() + rent);
            System.out.println(player.getName() + " pagou $" + rent + " de aluguel para " + owner.getName() + " pela " + propertyType + ".");
        } else {
            System.out.println(player.getName() + " não tem dinheiro suficiente para pagar o aluguel da " + propertyType + ".");
        }
    }

    
}
