package com.example.monopoly.places;

import java.util.ArrayList;
import java.util.Collections;

import com.example.monopoly.Board;
import com.example.monopoly.Player;
import com.example.monopoly.cards.Cards;
import com.example.monopoly.cards.PositionCard;
import com.example.monopoly.cards.MoneyCard;
import com.example.monopoly.cards.JailCard;

public class CommunityChest extends Place {
    private ArrayList<Cards> cards;
    private int currentIndex;
    private Place place;

    public CommunityChest(int position, String name, Board board, Place place){
        super(position, name, board);
        this.currentIndex = 0;
        this.cards = new ArrayList<>();
        this.place = place;
        initializeCards();
        shuffleCards();
    }

    public void setPlace(Place place) {
        this.place = place;  
    }

    private void initializeCards() {
        setPlace(this);
        cards.add(new PositionCard(1, "Avance para o Ponto de Partida (Go)", "Receba $200", 40, true, false, false, this));
        cards.add(new MoneyCard(2, "Erro do Banco em seu Favor", "Receba $200", 200, false, this));
        cards.add(new MoneyCard(3, "Taxa do Médico", "Pague $50", 50, true, this));
        cards.add(new MoneyCard(4, "Abertura da Grande Ópera", "Receba $50 de cada jogador pelas entradas", 50, false, this));
        cards.add(new MoneyCard(5, "Da Liquidação Fora de Estoque", "Receba $45", 40, false, this));
        cards.add(new JailCard(6, "Saia Livre da Prisão, sem pagar.", "Esta carta pode ser mantida até o uso ou venda. Veja a user story sobre a prisão.", this));
        cards.add(new PositionCard(7, "Vá para a Prisão", "Vá direto para a prisão. Não passe pelo ponto de partida. Não receba $200", 30, false, false, false, this));
        cards.add(new MoneyCard(8, "Restituição do Imposto de Renda", "Receba $20", 20, false, this));
        cards.add(new MoneyCard(9, "Aniversário do Seguro de Vida", "Receba $100", 100, false, this));
        cards.add(new MoneyCard(10, "Pague o Hospital", "Pague $100", 100, true, this));
        cards.add(new MoneyCard(11, "Pague Taxa da Escola", "Pague $150", 150, true, this));
        cards.add(new MoneyCard(12, "Receba por Seus Serviços", "Receba $25", 25, false, this));
        cards.add(new MoneyCard(13, "Aniversário dos Fundos de Natal", "Receba $100", 100, false, this));
        cards.add(new MoneyCard(14, "Você Tirou o Segundo Lugar no Concurso de Beleza", "Receba $10", 10, false, this));
        cards.add(new MoneyCard(15, "Você Herdou", "Receba $100", 100, false, this));
        cards.add(new MoneyCard(16, "Você deve pagar os reparos da rua", "Pague $40 por cada casa, $115 por hotel", 150, true, this));   
    }

    public Cards getRandomCard() {
        if (currentIndex >= cards.size()) {
            shuffleCards();
            currentIndex = 0;
        }

        Cards card = cards.get(currentIndex);
        currentIndex++;
        return card;
    }
    private void shuffleCards() {
        Collections.shuffle(cards);
    }


    @Override
    public void offerToBuy(Player player) {

    }

    @Override
    public void sellTo(Player player) {

    }

    public Place getPlace() {
        return place;
    }

    public void executarAcao(Player player) {
        System.out.println("The player advanced to position " + getPosition() + ", place: " + getName() + ".");
        Cards randomCard = getRandomCard();
        System.out.println(randomCard.getName());
        System.out.println(randomCard.getDescription());
        randomCard.executarAcao(player);
    }

    @Override
    public int getPrice() {
        return 0;
    };

    @Override
    public String getGroup() {
        return null;
    };
}
