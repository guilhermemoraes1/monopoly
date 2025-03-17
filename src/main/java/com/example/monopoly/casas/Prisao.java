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

    public Comando createComando(String comando) {
        return comandos.get(comando.toLowerCase());
    }

    @Override
    public void executarAcao(Player player) {
        System.out.println(" e o peão avançou para " + player.getPlayerPosition() + " – " + player.getName());

        if (!isVisitandoPrisao()) {
            System.out.println(" " + player.getName() + " está na prisão.");

            Scanner scanner = new Scanner(System.in);
            int valorFianca = 50;

            while (player.getJogadasSeguidas() < 3) {
                System.out.println("Comandos disponíveis: [pagar][carta][jogar][status][sair]");
                System.out.print("Entre com um comando: ");
                String comando = scanner.nextLine().toLowerCase();

                Comando comandoObjeto = createComando(comando);

                if (comandoObjeto != null) {
                    comandoObjeto.executar(player, scanner);
                } else {
                    System.out.println("Comando inválido. Tente novamente.");
                }

                if (player.getPlayerMoney() >= valorFianca || player.getJogadasSeguidas() == 0) {
                    break;
                }
            }

            if (player.getJogadasSeguidas() == 3) {

                System.out.println("Você não conseguiu sair da prisão após 3 tentativas. Pagou $50.");
                player.diminuirDinheiro(valorFianca);
                player.resetarJogadas();
            }
        } else {
            System.out.println(player.getName() + " está na prisão. Apenas visitando.");
        }
    }
}
