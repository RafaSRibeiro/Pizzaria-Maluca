package listas;

import principal.NoCartas;
import principal.SorteOuAzar;

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
            atual = atual.proximo;
        }
        return comp;
    }

    public void inserePrimeiro(SorteOuAzar s) {
        NoCartas novo = new NoCartas(s);
        if (estaVazio()) {
            primeiro = novo;
            ultimo = novo;
            atual = novo;
        } else {
            novo.proximo = primeiro;
            primeiro = novo;
        }
    }

    public void insereUltimo(SorteOuAzar s) {
        NoCartas novo = new NoCartas(s);
        if (estaVazio()) {
            primeiro = novo;
            ultimo = novo;
            atual = novo;
        } else {
            ultimo.proximo = novo;
            ultimo = novo;
        }
    }

    public void moveParaPosicao(int pos) {
        atual = primeiro;
        for (int i = 1; i <= pos; i++) {
            atual = atual.proximo;
        }
    }

    public SorteOuAzar retornaDaPosicao(int pos) {
        moveParaPosicao(pos);
        return atual.carta;
    }

    // Retorna a posi��o de um elemento na lista. Se n�o existir retorna um n�mero negativo
    public int buscaElemento(int n) {
        int cont = 0;
        atual = primeiro;

        while (atual != null && (atual.carta.getNumero() != n)) {
            atual = atual.proximo;
            cont++;
        }
        if (atual != null) {

            return cont;
        }
        return -1;
    }

    // Remove o primeiro elemento da lista
    public void removePrimeiro() {
        primeiro = primeiro.proximo;
    }

    // Remove o último elemento da lista
    public void removeUltimo() {
        int pos;
        pos = comprimento() - 1;
        moveParaPosicao(pos);
        atual.proximo = null;
    }


    // remove o elemento da posição indicada
    public SorteOuAzar removeNaPosicao(int pos) {
        if (pos == 0) {
            removePrimeiro();
            return null;
        }
        NoCartas temp;
        moveParaPosicao(pos);
        temp = atual.proximo;
        pos = pos - 1;
        moveParaPosicao(pos);
        atual.proximo = temp;
        return null;
    }

    public String mostra(int i) {
        moveParaPosicao(i);
        String a = atual.toString();
        return a;
    }


}
