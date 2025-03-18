package com.example.monopoly.places;

import java.util.ArrayList;
import java.util.Collections;

import com.example.monopoly.Board;
import com.example.monopoly.Player;
import com.example.monopoly.cartas.Cartas;
import com.example.monopoly.cartas.Movimento;
import com.example.monopoly.cartas.Pagamento;
import com.example.monopoly.cartas.SairPrisao;

public class CommunityChest extends Place {
    private ArrayList<Cartas> cartas;
    private int indexAtual;
    private Place place;

    public CommunityChest(int position, String name, Board board, Place place){
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

    private void inicializarCartas() {
        setPlace(this);
        cartas.add(new Movimento(1, "Avance para o Ponto de Partida (Go)", "Receba $200", 40, true, false, false, this));
        cartas.add(new Pagamento(2, "Erro do Banco em seu Favor", "Receba $200", 200, false, this));
        cartas.add(new Pagamento(3, "Taxa do Médico", "Pague $50", 50, true, this));
        cartas.add(new Pagamento(4, "Abertura da Grande Ópera", "Receba $50 de cada jogador pelas entradas", 50, false, this));
        cartas.add(new Pagamento(5, "Da Liquidação Fora de Estoque", "Receba $45", 40, false, this));
        cartas.add(new SairPrisao(6, "Saia Livre da Prisão, sem cartas.Pagar", "Esta carta pode ser mantida até o uso ou venda. Veja a user story sobre a prisão", this));
        cartas.add(new Movimento(7, "Vá para a Prisão", "Vá direto para a prisão – Não passe pelo ponto de partida – Não receba $200", 30, false, false, false, this));
        cartas.add(new Pagamento(8, "Restituição do Imposto de Renda", "Receba $20", 20, false, this));
        cartas.add(new Pagamento(9, "Aniversário do Seguro de Vida", "Receba $100", 100, false, this));
        cartas.add(new Pagamento(10, "Pague o Hospital", "Pague $100", 100, true, this));
        cartas.add(new Pagamento(11, "Pague Taxa da Escola", "Pague $150", 150, true, this));
        cartas.add(new Pagamento(12, "Receba por Seus Serviços", "Receba $25", 25, false, this));
        cartas.add(new Pagamento(13, "Aniversário dos Fundos de Natal", "Receba $100", 100, false, this));
        cartas.add(new Pagamento(14, "Você Tirou o Segundo Lugar no Concurso de Beleza", "Receba $10", 10, false, this));
        cartas.add(new Pagamento(15, "Você Herdou", "Receba $100", 100, false, this));
        cartas.add(new Pagamento(16, "Você deve pagar os reparos da rua", "Pague $40 por cada casa, $115 por hotel", 150, true, this));
            
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

    public void executarAcao(Player player) {
        System.out.println(" e o peão avançou para " + getPosition() + " – " + getName() + ".");
        Cartas cartaSorteada = getCartaAleatoria();
        System.out.println(cartaSorteada.getNome());
        System.out.println(cartaSorteada.getDescricao());
        cartaSorteada.executarAcao(player);
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
