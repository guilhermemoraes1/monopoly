package com.example.monopoly.places;


import com.example.monopoly.Board;
import com.example.monopoly.Player;
import com.example.monopoly.commands.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Jail extends Place{
    private boolean visitingJail;
    private Map<String, Command> commands;

    public Jail(int position, String name, boolean visitingJail, Board board) {
        super(position, name, board);
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
        commands = new HashMap<>();
        commands.put("card", new UseCardCommand());
        commands.put("pay", new PayCommand());
        commands.put("roll", new RollCommand());
        commands.put("status", new StatusCommand());
        commands.put("quit", new QuitCommand());
    }

    // private void inicializarComandos() {
    //     commands = new HashMap<>();
    //     commands.put("roll", new ComandoJogar());
    //     commands.put("pagar", new ComandoPagar());
    //     commands.put("carta", new ComandoCarta());
    //     commands.put("status", new ComandoStatus());
    //     commands.put("sair", new ComandoSair());
    // }

    public Command createCommand(String command) {
        return commands.get(command.toLowerCase());
    }

    @Override
    public void executarAcao(Player player) {
        System.out.println("The player advanced to position " + getPosition() + ", place: " + getName());

        if (!isVisitingJail()) {
            System.out.println(" " + player.getName() + " is in jail.");

            Scanner scanner = new Scanner(System.in);
            int fineValue = 50;

            while (player.getJogadasSeguidas() < 3) {
                System.out.println("Comandos disponíveis: [roll][card][pay][status][quit]");
                System.out.print("Enter a command: ");
                String command = scanner.nextLine().toLowerCase();

                Command cmd = createCommand(command);

                if (cmd != null) {
                    cmd.execute(player);
                } else {
                    System.out.println("Invalid command. Please try again.");
                }

                if ( player.getJogadasSeguidas() == 0) {
                    break;
                }
            }

            if (player.getJogadasSeguidas() == 3) {

                System.out.println("You failed to get out of jail after 3 attempts. Paid $50.");
                player.decreaseMoney(fineValue);
                player.resetarJogadas();
            }
        } else {
            System.out.println(player.getName() + " is in jail. Just visiting.");
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
