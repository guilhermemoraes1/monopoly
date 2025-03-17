package com.example.monopoly.casas;

import com.example.monopoly.Player;

import java.util.Scanner;

public class PublicService extends Casa{
    private int price;

    public PublicService(int position, String name, int price) {
        super(position, name);
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public void oferecerCompra(Player jogador) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("O título do serviço " + getName() + " está disponível por $" + getPrice() + ".");
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
            jogador.comprarPublicService(this);
        } else {
            System.out.println(jogador.getName() + ", você não tem dinheiro suficiente para comprar esta realestate.");
        }
    }

    @Override
    public void executarAcao(Player player) {
        System.out.println(" e o peão avançou para " + player.getPlayerPosition() + " – " + player.getName());

        if (getProprietario() != null) {
            System.out.println("O serviço público " + getName() + " já possui proprietário.");

            int taxa = getPrice();

            player.diminuirDinheiro(taxa);
            getProprietario().aumentarDinheiro(taxa);

            System.out.println("O jogador " + player.getName() + " pagou a taxa fixa de $" + taxa +
                    " para " + getProprietario().getName());
            System.out.println("Novo saldo: $" + player.getPlayerMoney());

        } else {
            oferecerCompra(player);
        }
    }

}
