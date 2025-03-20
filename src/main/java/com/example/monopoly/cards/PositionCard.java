package com.example.monopoly.cards;

import com.example.monopoly.Player;
import com.example.monopoly.places.Place;
import com.example.monopoly.places.PublicService;
import com.example.monopoly.places.Railroad;

import java.util.List;

public class PositionCard extends Cards {

    private int novaPosicao;
    private boolean canReceiveBonus;
    private boolean goToRailroad;
    private boolean goToPublicService;

    public PositionCard(int number, String name, String description, int novaPosicao, boolean canReceiveBonus, boolean goToRailroad, boolean goToPublicService, Place place) {
        super(number, name, description, place);
        this.novaPosicao = novaPosicao;
        this.canReceiveBonus = canReceiveBonus;
        this.goToRailroad = goToRailroad;
        this.goToPublicService = goToPublicService;
    }


    public int getNewPosition() {
        return novaPosicao;
    }

    public boolean isGetCanReceiveBonus() {
        return canReceiveBonus;
    }

    public boolean getGoToRailroad() {
        return goToRailroad;
    }

    public boolean isGetGoToPublicService() {
        return goToPublicService;
    }

    private Railroad findNearestRailroald(int currentPosition, List<Railroad> railroads) {
        Railroad nearestRailroad = railroads.get(0);
        int lessDistant = Math.min(
                (nearestRailroad.getPosition() - currentPosition + 40) % 40,
                (currentPosition - nearestRailroad.getPosition() + 40) % 40
        );

        for (Railroad railroad : railroads) {
            int distance = Math.min(
                    (railroad.getPosition() - currentPosition + 40) % 40,
                    (currentPosition - railroad.getPosition() + 40) % 40
            );

            if (distance < lessDistant) {
                lessDistant = distance;
                nearestRailroad = railroad;
            }
        }

        return nearestRailroad;
    }

    private PublicService encontrarServicoMaisProximo(int currentPosition, List<PublicService> servicoPublico) {
        PublicService servicoMaisProximo = servicoPublico.get(0);
        int lessDistant = Math.min(
                (servicoMaisProximo.getPosition() - currentPosition + 40) % 40,
                (currentPosition - servicoMaisProximo.getPosition() + 40) % 40
        );

        for (PublicService servico : servicoPublico) {
            int distance = Math.min(
                    (servico.getPosition() - currentPosition + 40) % 40,
                    (currentPosition - servico.getPosition() + 40) % 40
            );

            if (distance < lessDistant) {
                lessDistant = distance;
                servicoMaisProximo = servico;
            }
        }

        return servicoMaisProximo;
    }

    @Override
    public void executarAcao(Player player) {

        int currentPosition = player.getPlayerPosition();


        if(getGoToRailroad()){
            List<Railroad> railroads = getPlace().getBoard().getFerrovias();
            Railroad nearestRailroad = findNearestRailroald(currentPosition, railroads);
            player.mover(nearestRailroad.getPosition() - currentPosition);
            System.out.println("The player advanced to position " + nearestRailroad.getPosition() + ", place: " + nearestRailroad.getName() + ".");

        } else if (isGetGoToPublicService()) {
            List<PublicService> servicoPublicos = getPlace().getBoard().getServicoPublico();
            PublicService servicoMaisProximo = encontrarServicoMaisProximo(currentPosition, servicoPublicos);
            player.mover(servicoMaisProximo.getPosition() - currentPosition);
            System.out.println("The player advanced to position " + servicoMaisProximo.getPosition() + ", place: " + servicoMaisProximo.getName() + ".");
        } else {
            player.setPlayerPosition(getNewPosition());
            Place place = getPlace().getBoard().getPlace(player.getPlayerPosition() - 1);
            System.out.println("The player advanced to position " + player.getPlayerPosition() + ", place: " + place.getName() + ".");
        }

        int bonus = 200;
        if(isGetCanReceiveBonus()){
            player.increaseMoney(bonus);
        }
    }

}
