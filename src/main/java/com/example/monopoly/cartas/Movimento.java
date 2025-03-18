package com.example.monopoly.cartas;

import com.example.monopoly.Board;
import com.example.monopoly.Player;
import com.example.monopoly.places.Chance;
import com.example.monopoly.places.CommunityChest;
import com.example.monopoly.places.Place;
import com.example.monopoly.places.PublicService;
import com.example.monopoly.places.Railroad;

import java.util.List;

public class Movimento extends Cartas {

    private int novaPosicao;
    private boolean podeReceberBonus;
    private boolean irParaFerrovia;
    private boolean irParaServicoPublico;

    public Movimento(int numero, String nome, String descricao, int novaPosicao, boolean podeReceberBonus, boolean irParaFerrovia, boolean irParaServicoPublico, Place place) {
        super(numero, nome, descricao, place);
        this.novaPosicao = novaPosicao;
        this.podeReceberBonus = podeReceberBonus;
        this.irParaFerrovia = irParaFerrovia;
        this.irParaServicoPublico = irParaServicoPublico;
    }


    public int getNovaPosicao() {
        return novaPosicao;
    }

    public boolean isPodeReceberBonus() {
        return podeReceberBonus;
    }

    public boolean isIrParaFerrovia() {
        return irParaFerrovia;
    }

    public boolean isIrParaServicoPublico() {
        return irParaServicoPublico;
    }

    private Railroad encontrarFerroviaMaisProxima(int posicaoAtual, List<Railroad> ferrovias) {
        Railroad ferroviaMaisProxima = ferrovias.get(0);
        int menorDistancia = Math.min(
                (ferroviaMaisProxima.getPosition() - posicaoAtual + 40) % 40,
                (posicaoAtual - ferroviaMaisProxima.getPosition() + 40) % 40
        );

        for (Railroad ferrovia : ferrovias) {
            int distancia = Math.min(
                    (ferrovia.getPosition() - posicaoAtual + 40) % 40,
                    (posicaoAtual - ferrovia.getPosition() + 40) % 40
            );

            if (distancia < menorDistancia) {
                menorDistancia = distancia;
                ferroviaMaisProxima = ferrovia;
            }
        }

        return ferroviaMaisProxima;
    }

    private PublicService encontrarServicoMaisProximo(int posicaoAtual, List<PublicService> servicoPublico) {
        PublicService servicoMaisProximo = servicoPublico.get(0);
        int menorDistancia = Math.min(
                (servicoMaisProximo.getPosition() - posicaoAtual + 40) % 40,
                (posicaoAtual - servicoMaisProximo.getPosition() + 40) % 40
        );

        for (PublicService servico : servicoPublico) {
            int distancia = Math.min(
                    (servico.getPosition() - posicaoAtual + 40) % 40,
                    (posicaoAtual - servico.getPosition() + 40) % 40
            );

            if (distancia < menorDistancia) {
                menorDistancia = distancia;
                servicoMaisProximo = servico;
            }
        }

        return servicoMaisProximo;
    }

    @Override
    public void executarAcao(Player peca) {
        System.out.println("\nAvançando para " + getNovaPosicao() + ".");

        int posicaoAtual = peca.getPlayerPosition();


        if(isIrParaFerrovia()){

            List<Railroad> ferrovias = getPlace().getBoard().getFerrovias();
            Railroad ferroviaMaisProxima = encontrarFerroviaMaisProxima(posicaoAtual, ferrovias);
            peca.mover(ferroviaMaisProxima.getPosition() - posicaoAtual);
            System.out.println("O peão avançou para " + ferroviaMaisProxima.getPosition() + " – " + ferroviaMaisProxima.getName() + ".");

        } else if (isIrParaServicoPublico()) {
            List<PublicService> servicoPublicos = getPlace().getBoard().getServicoPublico();
            PublicService servicoMaisProximo = encontrarServicoMaisProximo(posicaoAtual, servicoPublicos);
            peca.mover(servicoMaisProximo.getPosition() - posicaoAtual);
            System.out.println("O peão avançou para " + servicoMaisProximo.getPosition() + " – " + servicoMaisProximo.getName() + ".");

        } else {

            peca.mover(getNovaPosicao() - peca.getPlayerPosition());
            Place place = getPlace().getBoard().getPlace(peca.getPlayerPosition());
            System.out.println("O peão avançou para " + peca.getPlayerPosition() + " – " + place.getName() + ".");

        }

        int bonus = 200;
        if(isPodeReceberBonus()){
            peca.increaseMoney(bonus);
        }
    }

}
