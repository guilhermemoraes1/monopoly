package com.example.monopoly.places;

import java.util.ArrayList;
import java.util.Collections;

import com.example.monopoly.Board;
import com.example.monopoly.Player;
import com.example.monopoly.cards.Cards;
import com.example.monopoly.cards.GoToJailCard;
import com.example.monopoly.cards.PositionCard;
import com.example.monopoly.cards.MoneyCard;
import com.example.monopoly.cards.JailCard;

public class Chance extends Place {
    private ArrayList<Cards> cards;
    private int currentIndex;
    private Place place;


    public Chance(int position, String name, Board board, Place place){
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

    public void initializeCards() {
        setPlace(this);
        cards.add(new PositionCard(1, "Avance para o Ponto de Partida", "Receba $200", 40, true, false, false, this));
        cards.add(new PositionCard(2, "Avance para Illinois Avenue", "O jogador não recebe $200 se passar pelo Ponto de Partida.", 24, false, false, false, this));
        cards.add(new PositionCard(3, "Avance para St. Charles Place", "Se passar pelo Ponto de Partida, receba $200", 11, true, false, false, this));
        cards.add(new PositionCard(4, "Avance o peão para o serviço público mais próximo", "Se não tiver dono, você pode comprá-lo do banco. Se tiver, lance os dados e pague ao dono 10 vezes o resultado do lançamento. O jogador não recebe $200 se passar pelo Ponto de Partida.", 2, false, false, true, this));
        cards.add(new PositionCard(5, "Avance o peão para a ferrovia mais próxima", "Pague ao dono duas vezes o valor que ele deveria receber normalmente. Se a ferrovia não tiver dono, você pode comprá-la do banco. O jogador não recebe $200 se passar pelo Ponto de Partida.", 5, false, true, false, this));
        cards.add(new MoneyCard(6, "O banco lhe pagou dividendos de $50", "", 50, false, this));
        cards.add(new PositionCard(7, "Volte 3 espaços", "", 3, false, false, false, this));
        cards.add(new GoToJailCard(8, "Vá diretamente para a Prisão", "Não passe pelo ponto de partida, não receba $200.", this));
        //cards.add(new MoneyCard(9, "Faça a manutenção de todas as suas propriedades", "Para cada casa, pague $25; para cada hotel, pague $10. Somente para casas e hotéis que o jogador construiu.", 10, true, this));
        cards.add(new MoneyCard(9, "Pague imposto de pobreza de $15", "", 15, true, this));
        cards.add(new JailCard(10, "Esta carta pode ser mantida até seu uso ou venda", "Sair Livre da Prisão.", this));
        cards.add(new PositionCard(11, "Dê uma volta na Reading", "Se você passar pelo Ponto de Partida, receba $200", 5, true, false, false, this));
        cards.add(new PositionCard(12, "Dê uma caminhada no Board Walk", "Avance o peão para Board Walk", 39, false, false, false, this));
        cards.add(new MoneyCard(13, "Você foi eleito presidente do tabuleiro", "Pague $50 para cada jogador", 50, true, this));
        cards.add(new MoneyCard(14, "Seus empréstimos e investimentos fizeram aniversário", "Receba $150", 150, false, this));

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

    @Override
    public void executarAcao(Player player) {
        System.out.println("The player advanced to position " + getPosition() + ", place: " + getName() + ".");
        Cards randomCard = getRandomCard();

        if(randomCard.getNumber() == 7){
            player.voltar(3, getBoard());

        } else {

            System.out.println(randomCard.getName());
            System.out.println(randomCard.getDescription());
            randomCard.executarAcao(player);
        }

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
