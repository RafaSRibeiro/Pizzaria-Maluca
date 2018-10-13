package pizza;

import library.Pizza;
import listas.ListaDupla;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class PizzaPortuguesa extends Pizza {

    ListaDupla lista = new ListaDupla();

    int Jogador;

    int qt;

    ArrayList<String> faltam = new ArrayList<>();

    public int getQt() {
        return qt;
    }

    public void setQt(int qt) {
        this.qt = qt;
    }

    public int getJogador() {
        return Jogador;
    }

    public void setJogador(int jogador) {
        Jogador = jogador;
    }

    public ArrayList<String> faltamEssesIngredientes() {
        ArrayList<String> ingredientes = new ArrayList<>();
        ingredientes.add("Milho");
        ingredientes.add("Ovos");
        ingredientes.add("Queijo");
        ingredientes.add("Azeitona");
        ingredientes.add("Presunto");

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

    public PizzaPortuguesa(int jogador) {
        lista.inserePrimeiro("presunto", 0);
        lista.inserePrimeiro("azeitona", 0);
        lista.inserePrimeiro("queijo", 0);
        lista.inserePrimeiro("ovos", 0);
        lista.inserePrimeiro("milho", 0);
        setJogador(jogador);
        setQt(5);
        setRodadaSemJogar(false);

    }

    public void limpaPizza() {
        for (int i = 0; i < getQt(); i++)
            lista.removePrimeiro();

        lista.inserePrimeiro("presunto", 0);
        lista.inserePrimeiro("azeitona", 0);
        lista.inserePrimeiro("queijo", 0);
        lista.inserePrimeiro("ovos", 0);
        lista.inserePrimeiro("milho", 0);
        setQt(5);
    }

    public void perdeIngredienteX(String elemento) {
        if (lista.buscaElemento(elemento) > -1) {
            lista.removeElemento(elemento);
            setQt(getQt() - 1);
            System.out.println("O Jogador " + getJogador() + " pegou " + elemento + "!");
        }
        verificaSeGanhou();
    }

    public int ganhaIngredienteAleatorio() {
        Random n = new Random();
        int num;
        while (true) {
            if (getQt() == 5) {
                System.out.println("Sua Pizza ja esta vazia!");
                return 1;
            }
            num = n.nextInt(5);
            if (lista.buscaElemento("presunto") == -1 && num == 0) {
                lista.inserePrimeiro("presunto", 0);
                System.out.println("O jogador " + getJogador() + " perdeu presunto");
                setQt(getQt() + 1);

                return 1;
            }
            if (lista.buscaElemento("azeitona") == -1 && num == 1) {
                lista.inserePrimeiro("azeitona", 0);
                System.out.println("O jogador " + getJogador() + " perdeu azeitona");
                setQt(getQt() + 1);

                return 1;
            }
            if (lista.buscaElemento("queijo") == -1 && num == 2) {
                lista.inserePrimeiro("queijo", 0);
                System.out.println("O jogador " + getJogador() + " perdeu queijo");
                setQt(getQt() + 1);

                return 1;
            }
            if (lista.buscaElemento("ovos") == -1 && num == 3) {
                lista.inserePrimeiro("ovos", 0);
                System.out.println("O jogador " + getJogador() + " perdeu ovos");
                setQt(getQt() + 1);

                return 1;
            }
            if (lista.buscaElemento("milho") == -1 && num == 4) {
                lista.inserePrimeiro("milho", 0);
                System.out.println("O jogador " + getJogador() + " perdeu milho");
                setQt(getQt() + 1);

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
