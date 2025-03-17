package com.example.monopoly.casas;

import com.example.monopoly.Player;

import java.util.Scanner;

public class RealEstate extends Casa {
    private String grupo;
    private int price;
    private int rent;

    public RealEstate(int position, String name, String grupo, int price, int rent) {
        super(position, name);
        this.grupo = grupo;
        this.price = price;
        this.rent = rent;
    }

    public String getGrupo() {
        return grupo;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    @Override
    public void oferecerCompra(Player jogador) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("A título da propriedade " + getName() + " está disponível por $" + getPrice() + ".");
        System.out.println(jogador.getName() + ", você possui $" + jogador.getPlayerMoney() + ".");

        System.out.print("Você deseja comprar " + getName() +  " (Sim/Não)? ");
        String resposta = scanner.nextLine();
        if (resposta.equalsIgnoreCase("Sim")) {
            venderPara(jogador);
        }

        
    }

    @Override
    public void venderPara(Player jogador) {
        if (jogador.getPlayerMoney() >= getPrice()) {
            jogador.comprarRealEstate(this);
        } else {
            System.out.println(jogador.getName() + ", você não tem dinheiro suficiente para comprar esta propriedade.");
        }
    }

    @Override
    public void executarAcao(Player player) {
        System.out.println(" e o peão avançou para " + getPosition() + " – " + getName());

        if (getProprietario() != null) {
            System.out.println("A propriedade " + getName() + " já possui proprietário.");

            int taxa = getRent();

            player.diminuirDinheiro(taxa);
            getProprietario().aumentarDinheiro(taxa);

            System.out.println("O jogador " + player.getName() + " pagou o rent de $" + taxa +
                    " para " + getProprietario().getName());
            System.out.println("Novo saldo: $" + player.getPlayerMoney());

        } else {
            oferecerCompra(player);
        }
    }
}
