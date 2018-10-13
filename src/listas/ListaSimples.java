package listas;

import estrutura_de_dados.NoProjeto;

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
     while(atual != null) {
          comp++;
          atual = atual.proximo;
     }
     return comp;
	}
	public void inserePrimeiro(String n, int t) {
     NoProjeto novo = new NoProjeto(n,t);
     if (estaVazio()) {
       primeiro = novo;
       ultimo = novo;
       atual = novo;
     } else {
       novo.proximo = primeiro;
       primeiro = novo;
     }
	}

	public void insereUltimo(String n, int t) {
     NoProjeto novo = new NoProjeto(n,t);

     if (estaVazio()) {
       primeiro = novo;
       ultimo = novo;
       atual = novo;
     } else {
       ultimo.proximo = novo;
       ultimo = novo;
     }
	}

// Move para a posi��o indicada

	public void moveParaPosicao(int pos) {
     atual = primeiro;
     for (int i=1; i<pos; i++) {
        atual = atual.proximo;
     }
	}
// Insere um novo objeto na posi��o indicada

	public void insereNaPosicao(String n, int t, int pos) {
     NoProjeto novo = new NoProjeto(n,t);
     moveParaPosicao(pos);
     novo.proximo=atual.proximo;
     atual.proximo=novo;
	}

// Retorna o primeiro elemento da lista

	public NoProjeto primeiro() {
     return primeiro;
	}

// Retorna o �ltimo elemento da lista

	public NoProjeto ultimo() {
     return ultimo;
	}
// Retorna o elemento na posi��o indicada
	public NoProjeto elementoNaPosicao(int pos) {
    	moveParaPosicao(pos);
    	return atual;
	}

// Retorna a posi��o de um elemento na lista. Se n�o existir retorna um n�mero negativo
	public int buscaElemento(String n) {
     int cont = 0;
     atual = primeiro;

     while(atual != null && !atual.nomeEtapa.equals(n)) {
       atual = atual.proximo;
       cont ++;
     }
     if (atual != null)
        return cont;
     return -1;
	}
	
// Remove o primeiro elemento da lista
	public void removePrimeiro(){
		primeiro = primeiro.proximo;
	}
	
// Remove o último elemento da lista
	public void removeUltimo(){
		int pos;
		pos=comprimento() - 1;
		moveParaPosicao(pos);
		atual.proximo = null;
	}
	
// Remove da lista o elemento indicado
	public void removeElemento(String elemento){
		int pos;
		NoProjeto temp;
		pos = buscaElemento(elemento);
		if(pos > -1){
			temp = atual.proximo;
			pos = pos-1;
			moveParaPosicao(pos);
			atual.proximo=temp;
		}
	}
	
// Remove o elemento da posição indicada
	public void removeNaPosicao(int pos){
		NoProjeto temp;
		moveParaPosicao(pos);
		temp=atual.proximo;
		pos = pos - 1;
		moveParaPosicao(pos);
		atual.proximo=temp;
	}
}
