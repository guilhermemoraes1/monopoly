package com.example.monopoly.casas;


import com.example.monopoly.Player;
import com.example.monopoly.casas.command.*;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Prisao extends Casa{
    private boolean visitandoPrisao;
    private Map<String, Comando> comandos;

    public Prisao(int posicao, String nome, boolean visitandoPrisao) {
        super(posicao, nome);
        this.visitandoPrisao = visitandoPrisao;
        inicializarComandos();
    }

    public boolean isVisitandoPrisao() {
        return visitandoPrisao;
    }

    @Override
    public void oferecerCompra(Player jogador) {

    }
    @Override
    public void venderPara(Player jogador) {

    }

    private void inicializarComandos() {
        comandos = new HashMap<>();
        comandos.put("jogar", new ComandoJogar());
        comandos.put("pagar", new ComandoPagar());
        comandos.put("carta", new ComandoCarta());
        comandos.put("status", new ComandoStatus());
        comandos.put("sair", new ComandoSair());
    }

    public Comando criarComando(String comando) {
        return comandos.get(comando.toLowerCase());
    }

    @Override
    public void executarAcao(Player peca) {
        System.out.println(" e o peão avançou para " + peca.getPlayerPosition() + " – " + peca.getName());

        if (!isVisitandoPrisao()) {
            System.out.println(" " + peca.getName() + " está na prisão.");

            Scanner scanner = new Scanner(System.in);
            int valorFianca = 50;

            while (peca.getJogadasSeguidas() < 3) {
                System.out.println("Comandos disponíveis: [pagar][carta][jogar][status][sair]");
                System.out.print("Entre com um comando: ");
                String comando = scanner.nextLine().toLowerCase();

                Comando comandoObjeto = criarComando(comando);

                if (comandoObjeto != null) {
                    comandoObjeto.executar(peca, scanner);
                } else {
                    System.out.println("Comando inválido. Tente novamente.");
                }

                if (peca.getPlayerMoney() >= valorFianca || peca.getJogadasSeguidas() == 0) {
                    break;
                }
            }

            if (peca.getJogadasSeguidas() == 3) {

                System.out.println("Você não conseguiu sair da prisão após 3 tentativas. Pagou $50.");
                peca.diminuirDinheiro(valorFianca);
                peca.resetarJogadas();
            }
        } else {
            System.out.println(peca.getName() + " está na prisão. Apenas visitando.");
        }
    }
}
