package listas;

import principal.NoProjeto;

public class ListaSimples {

    private NoProjeto primeiro, ultimo, atual;

    public ListaSimples() {
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

    public void inserePrimeiro(String n, int t) {
        NoProjeto novo = new NoProjeto(n, t);
        if (estaVazio()) {
            primeiro = novo;
            ultimo = novo;
            atual = novo;
        } else {
            novo.setProximo(primeiro);
            primeiro = novo;
        }
    }

    public void insereUltimo(String n, int t) {
        NoProjeto novo = new NoProjeto(n, t);

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
        for (int i = 1; i < pos; i++) {
            atual = atual.getProximo();
        }
    }

    public void insereNaPosicao(String n, int t, int pos) {
        NoProjeto novo = new NoProjeto(n, t);
        moveParaPosicao(pos);
        novo.setProximo(atual.getProximo());
        atual.setProximo(novo);
    }

    public NoProjeto primeiro() {
        return primeiro;
    }

    public NoProjeto ultimo() {
        return ultimo;
    }

    public NoProjeto elementoNaPosicao(int pos) {
        moveParaPosicao(pos);
        return atual;
    }

    public int buscaElemento(String n) {
        int cont = 0;
        atual = primeiro;

        while (atual != null && !atual.getNomeEtapa().equals(n)) {
            atual = atual.getProximo();
            cont++;
        }
        if (atual != null)
            return cont;
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

    public void removeElemento(String elemento) {
        int pos;
        NoProjeto temp;
        pos = buscaElemento(elemento);
        if (pos > -1) {
            temp = atual.getProximo();
            pos = pos - 1;
            moveParaPosicao(pos);
            atual.setProximo(temp);
        }
    }

    public void removeNaPosicao(int pos) {
        NoProjeto temp;
        moveParaPosicao(pos);
        temp = atual.getProximo();
        pos = pos - 1;
        moveParaPosicao(pos);
        atual.setProximo(temp);
    }
}
