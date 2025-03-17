package com.example.monopoly.casas;

import com.example.monopoly.Player;

import java.util.Scanner;

public class ServicoPublico extends Casa{
    private int preco;

    public ServicoPublico(int posicao, String nome, int preco) {
        super(posicao, nome);
        this.preco = preco;
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    @Override
    public void oferecerCompra(Player jogador) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("O título do serviço " + getName() + " está disponível por $" + getPreco() + ".");
        System.out.println(jogador.getName() + ", você possui $" + jogador.getPlayerMoney() + ".");

        System.out.print("Você deseja comprar " + getName() +  " (Sim/Não)? ");
        String resposta = scanner.nextLine();
        if (resposta.equalsIgnoreCase("Sim")) {
            venderPara(jogador);
        }
        

    }

    @Override
    public void venderPara(Player jogador) {
        if (jogador.getPlayerMoney() >= getPreco()) {
            jogador.comprarServicoPublico(this);
        } else {
            System.out.println(jogador.getName() + ", você não tem dinheiro suficiente para comprar esta propriedade.");
        }
    }

    @Override
    public void executarAcao(Player peca) {
        System.out.println(" e o peão avançou para " + peca.getPlayerPosition() + " – " + peca.getName());

        if (getProprietario() != null) {
            System.out.println("O serviço público " + getName() + " já possui proprietário.");

            int taxa = getPreco();

            peca.diminuirDinheiro(taxa);
            getProprietario().aumentarDinheiro(taxa);

            System.out.println("O jogador " + peca.getName() + " pagou a taxa fixa de $" + taxa +
                    " para " + getProprietario().getName());
            System.out.println("Novo saldo: $" + peca.getPlayerMoney());

        } else {
            oferecerCompra(peca);
        }
    }

}
