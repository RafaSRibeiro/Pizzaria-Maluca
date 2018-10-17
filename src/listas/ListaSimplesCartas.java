package listas;

import principal.NoCartas;
import principal.CartaSorteOuAzar;

public class ListaSimplesCartas {

    private NoCartas primeiro, ultimo, atual;

    public ListaSimplesCartas() {
        primeiro = ultimo = atual = null;
    }

    public boolean estaVazio() {
        return primeiro == null;
    }

    public int comprimento() {
        int comp = 0;
        atual = primeiro;
        while (atual != null) {
            comp++;
            atual = atual.getProximo();
        }
        return comp;
    }

    public void inserePrimeiro(CartaSorteOuAzar s) {
        NoCartas novo = new NoCartas(s);
        if (estaVazio()) {
            primeiro = novo;
            ultimo = novo;
            atual = novo;
        } else {
            novo.setProximo(primeiro);
            primeiro = novo;
        }
    }

    public void insereUltimo(CartaSorteOuAzar s) {
        NoCartas novo = new NoCartas(s);
        if (estaVazio()) {
            primeiro = novo;
            ultimo = novo;
            atual = novo;
        } else {
            ultimo.setProximo(novo);
            ultimo = novo;
        }
    }

    public void moveParaPosicao(int pos) {
        atual = primeiro;
        for (int i = 1; i <= pos; i++) {
            atual = atual.getProximo();
        }
    }

    public CartaSorteOuAzar retornaDaPosicao(int pos) {
        moveParaPosicao(pos);
        return atual.getCarta();
    }

    public int buscaElemento(int n) {
        int cont = 0;
        atual = primeiro;

        while (atual != null && (atual.getCarta().getNumero() != n)) {
            atual = atual.getProximo();
            cont++;
        }
        if (atual != null) {

            return cont;
        }
        return -1;
    }

    public void removePrimeiro() {
        primeiro = primeiro.getProximo();
    }

    public void removeUltimo() {
        int pos;
        pos = comprimento() - 1;
        moveParaPosicao(pos);
        atual.setProximo(null);
    }


    public CartaSorteOuAzar removeNaPosicao(int pos) {
        if (pos == 0) {
            removePrimeiro();
            return null;
        }
        NoCartas temp;
        moveParaPosicao(pos);
        temp = atual.getProximo();
        pos = pos - 1;
        moveParaPosicao(pos);
        atual.setProximo(temp);
        return null;
    }

    public String mostra(int i) {
        moveParaPosicao(i);
        String a = atual.toString();
        return a;
    }

}
