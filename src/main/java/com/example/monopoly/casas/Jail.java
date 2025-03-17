package com.example.monopoly.casas;


import com.example.monopoly.Player;
import com.example.monopoly.casas.jailCommands.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Jail extends Casa{
    private boolean visitingJail;
    private Map<String, Comando> comandos;

    public Jail(int position, String name, boolean visitingJail) {
        super(position, name);
        this.visitingJail = visitingJail;
        inicializarComandos();
    }

    public boolean isVisitingJail() {
        return visitingJail;
    }

    @Override
    public void offerToBuy(Player player) {

    }
    @Override
    public void sellTo(Player player) {

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

        if (!isVisitingJail()) {
            System.out.println(" " + player.getName() + " está na prisão.");

            Scanner scanner = new Scanner(System.in);
            int fineValue = 50;

            while (player.getJogadasSeguidas() < 3) {
                System.out.println("Comandos disponíveis: [pagar][carta][jogar][status][sair]");
                System.out.print("Entre com um comando: ");
                String comando = scanner.nextLine().toLowerCase();

                Comando comandoObjeto = createComando(comando);

                if (comandoObjeto != null) {
                    comandoObjeto.executar(player);
                } else {
                    System.out.println("Comando inválido. Tente novamente.");
                }

                if (player.getPlayerMoney() >= fineValue || player.getJogadasSeguidas() == 0) {
                    break;
                }
            }

            if (player.getJogadasSeguidas() == 3) {

                System.out.println("Você não conseguiu sair da prisão após 3 tentativas. Pagou $50.");
                player.decreaseMoney(fineValue);
                player.resetarJogadas();
            }
        } else {
            System.out.println(player.getName() + " está na prisão. Apenas visitando.");
        }
    }
}
