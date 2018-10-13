package pizza;

import library.Pizza;
import listas.ListaDupla;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class PizzaMarguerita extends Pizza {

    ListaDupla lista = new ListaDupla();

    ArrayList<String> faltam = new ArrayList<>();

    public ArrayList<String> faltamEssesIngredientes() {
        ArrayList<String> ingredientes = new ArrayList<>();
        ingredientes.add("Milho");
        ingredientes.add("Queijo");
        ingredientes.add("Tomate");
        ingredientes.add("Brocolis");
        ingredientes.add("Calabresa");

        faltam.clear();

        for (int j = 0; j < ingredientes.size(); j++) {
            String ing = ingredientes.get(j);
            for (int i = 1; i < this.lista.tamanho() + 1; i++) {
                if (ing.equalsIgnoreCase(this.lista.elementoNaPosicao(i).getNomeEtapa())) {
                    this.faltam.add(ingredientes.get(j));
                    ingredientes.remove(j);
                    j--;
                }
            }
        }

        return faltam;
    }

    public PizzaMarguerita(int jogador) {
        lista.inserePrimeiro("calabresa", 0);
        lista.inserePrimeiro("brocolis", 0);
        lista.inserePrimeiro("tomate", 0);
        lista.inserePrimeiro("queijo", 0);
        lista.inserePrimeiro("milho", 0);
        setJogador(jogador);
        setQuantidade(5);
        setRodadaSemJogar(false);

    }


    public void limpaPizza() {
        for (int i = 0; i < getQuantidade(); i++)
            lista.removePrimeiro();

        lista.inserePrimeiro("calabresa", 0);
        lista.inserePrimeiro("brocolis", 0);
        lista.inserePrimeiro("tomate", 0);
        lista.inserePrimeiro("queijo", 0);
        lista.inserePrimeiro("milho", 0);

        setQuantidade(5);

    }

    public void perdeIngredienteX(String elemento) {
        if (lista.buscaElemento(elemento) > -1) {
            lista.removeElemento(elemento);
            setQuantidade(getQuantidade() - 1);
            System.out.println("O Jogador " + getJogador() + " pegou " + elemento + "!");
        }
        verificaSeGanhou();
    }

    public int ganhaIngredienteAleatorio() {
        Random n = new Random();
        int num;
        while (true) {
            if (getQuantidade() == 5) {
                System.out.println("Sua Pizza ja esta vazia!");
                return 1;
            }
            num = n.nextInt(5);
            if (lista.buscaElemento("calabresa") == -1 && num == 0) {
                lista.inserePrimeiro("calabresa", 0);
                System.out.println("O jogador " + getJogador() + " perdeu calabresa");
                setQuantidade(getQuantidade() + 1);

                return 1;
            }
            if (lista.buscaElemento("brocolis") == -1 && num == 1) {
                lista.inserePrimeiro("brocolis", 0);
                System.out.println("O jogador " + getJogador() + " perdeu brocolis");
                setQuantidade(getQuantidade() + 1);

                return 1;
            }
            if (lista.buscaElemento("tomate") == -1 && num == 2) {
                lista.inserePrimeiro("tomate", 0);
                System.out.println("O jogador " + getJogador() + " perdeu tomate");
                setQuantidade(getQuantidade() + 1);

                return 1;
            }
            if (lista.buscaElemento("queijo") == -1 && num == 3) {
                lista.inserePrimeiro("queijo", 0);
                System.out.println("O jogador " + getJogador() + " perdeu queijo");
                setQuantidade(getQuantidade() + 1);

                return 1;
            }
            if (lista.buscaElemento("milho") == -1 && num == 4) {
                lista.inserePrimeiro("milho", 0);
                System.out.println("O jogador " + getJogador() + " perdeu milho");
                setQuantidade(getQuantidade() + 1);

                return 1;
            }
        }
    }

    public void verificaSeGanhou() {
        if (lista.isVazio()) {
            System.out.println("O Jogador " + getJogador() + " ganhou!");
            JOptionPane.showMessageDialog(null, "O Jogador " + getJogador() + " ganhou!");
            System.exit(0);
        }
    }

}
