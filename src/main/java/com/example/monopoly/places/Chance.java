package com.example.monopoly.places;

import java.util.ArrayList;
import java.util.Collections;

import com.example.monopoly.Board;
import com.example.monopoly.Player;
import com.example.monopoly.cartas.Cartas;
import com.example.monopoly.cartas.Movimento;
import com.example.monopoly.cartas.Pagamento;
import com.example.monopoly.cartas.SairPrisao;

public class Chance extends Place {
    private ArrayList<Cartas> cartas;
    private int indexAtual;
    private Place place;


    public Chance(int position, String name, Board board, Place place){
        super(position, name, board);
        this.indexAtual = 0;
        this.cartas = new ArrayList<>();
        this.place = place;
        inicializarCartas();
        embaralharCartas();
    }

    public void setPlace(Place place) {
        this.place = place;  
    }

    public void inicializarCartas() {
        setPlace(this);
        cartas.add(new Movimento(1, "Avance para o Ponto de Partida", "Receba $200", 40, true, false, false, this));
        cartas.add(new Movimento(2, "Avance para Illinois Avenue", "O jogador não recebe $200 se passar pelo Ponto de Partida.", 24, false, false, false, this));
        cartas.add(new Movimento(3, "Avance para St. Charles Place", "Se passar pelo Ponto de Partida, receba $200", 11, true, false, false, this));
        cartas.add(new Movimento(4, "Avance o peão para o serviço público mais próximo", "Se não tiver dono, você pode comprá-lo do banco. Se tiver, lance os dados e pague ao dono 10 vezes o resultado do lançamento. O jogador não recebe $200 se passar pelo Ponto de Partida.", 2, false, false, true, this));
        cartas.add(new Movimento(5, "Avance o peão para a ferrovia mais próxima", "Pague ao dono duas vezes o valor que ele deveria receber normalmente. Se a ferrovia não tiver dono, você pode comprá-la do banco. O jogador não recebe $200 se passar pelo Ponto de Partida.", 5, false, true, false, this));
        cartas.add(new Pagamento(6, "O banco lhe pagou dividendos de $50", "", 50, false, this));
        cartas.add(new Movimento(7, "Volte 3 espaços", "", 3, false, false, false, this));
        cartas.add(new Movimento(8, "Vá diretamente para a Prisão", "Não passe pelo ponto de partida, não receba $200.", 30, false, false, false, this));
        cartas.add(new Pagamento(9, "Faça a manutenção de todas as suas propriedades", "Para cada casa, pague $25; para cada hotel, pague $10. Somente para casas e hotéis que o jogador construiu.", 10, true, this));
        cartas.add(new Pagamento(10, "Pague imposto de pobreza de $15", "", 15, true, this));
        cartas.add(new SairPrisao(11, "Esta carta pode ser mantida até seu uso ou venda", "Sair Livre da Prisão.", this));
        cartas.add(new Movimento(12, "Dê uma volta na Reading", "Se você passar pelo Ponto de Partida, receba $200", 5, true, false, false, this));
        cartas.add(new Movimento(13, "Dê uma caminhada no Board Walk", "Avance o peão para Board Walk", 39, false, false, false, this));
        cartas.add(new Pagamento(14, "Você foi eleito presidente do tabuleiro", "Pague $50 para cada jogador", 50, true, this));
        cartas.add(new Pagamento(15, "Seus empréstimos e investimentos fizeram aniversário", "Receba $150", 150, false, this));

    }

    public Cartas getCartaAleatoria() {
        if (indexAtual >= cartas.size()) {
            embaralharCartas();
            indexAtual = 0;
        }

        Cartas carta = cartas.get(indexAtual);
        indexAtual++;
        return carta;
    }

    private void embaralharCartas() {
        Collections.shuffle(cartas);
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
        System.out.println(" e o peão avançou para " + getPosition() + " – " + getName() + ".");
        Cartas cartaSorteada = getCartaAleatoria();

        if(cartaSorteada.getNumero() == 7){
            player.voltar(3, getBoard());

        } else {

            System.out.println(cartaSorteada.getNome());
            System.out.println(cartaSorteada.getDescricao());
            cartaSorteada.executarAcao(player);
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
