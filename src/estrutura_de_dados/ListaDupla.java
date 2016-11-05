package estrutura_de_dados;

public class ListaDupla {
    private  NoProjetoDupla primeiro, ultimo, atual;

    public ListaDupla() {
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
     NoProjetoDupla novo = new NoProjetoDupla(n,t);
     if (estaVazio()) {
       primeiro = novo;
       ultimo = novo;
       atual = novo;
     } else {
       primeiro.anterior = novo; //anterior do primeiro passa a ser o novo
       novo.proximo = primeiro;
       primeiro = novo;
     }
	}

	public void insereUltimo(String n, int t) {
     NoProjetoDupla novo = new NoProjetoDupla(n,t);

     if (estaVazio()) {
       primeiro = novo;
       ultimo = novo;
       atual = novo;
     } else {
       novo.anterior = ultimo; //ultimo é o anterior do novo ultimo
       ultimo.proximo = novo;
       ultimo = novo;
     }
	}

// Move para a posi��o indicada

	public NoProjetoDupla moveParaPosicao(int pos) { 
		//double tamanho = comprimento();
		//if( (tamanho/2) >= pos) { 		//se a posicao estiver na primeira metade da fila
			atual = primeiro;			//começa pelo primeiro
			for (int i=1; i<pos; i++)
				atual = atual.proximo;
		//}
		//else{							//senao, começa pelo ultimo
		//	atual = ultimo;
		//	for (int i=1; i<(tamanho-pos); i++)
		//		atual = atual.anterior;
		//}
			return atual;
	}
// Insere um novo objeto na posi��o indicada

	public void insereNaPosicao(String n, int t, int pos) {
     NoProjetoDupla novo = new NoProjetoDupla(n,t);
     
     moveParaPosicao(pos);
     
     //atual.proximo.anterior = novo; //o novo vai ser o anterior do proximo do atual.
     novo.proximo=atual.proximo;
     novo.anterior = atual; //anterior do novo vai ser o atual
     atual.proximo=novo;
	}

// Retorna o primeiro elemento da lista

	public NoProjetoDupla primeiro() {
     return primeiro;
	}

// Retorna o �ltimo elemento da lista

	public NoProjetoDupla ultimo() {
     return ultimo;
	}
// Retorna o elemento na posi��o indicada
	public NoProjetoDupla elementoNaPosicao(int pos) {
    	moveParaPosicao(pos);
    	return atual;
	}

// Retorna a posi��o de um elemento na lista. Se n�o existir retorna um n�mero negativo
	public int buscaElemento(String n) {
     int cont = 0;
     atual = primeiro;

     while(atual != null && !atual.nomeEtapa.equalsIgnoreCase(n)) {
       atual = atual.proximo;
       cont ++;
     }
     if (atual != null)
        return cont;
     return -1;
	}
	
// Remove o primeiro elemento da lista
	public void removePrimeiro(){
		if(primeiro.proximo == null){
	         primeiro = ultimo = atual = null;
		}
		else{
		primeiro = primeiro.proximo;
		primeiro.anterior = null; // remove o anterior do primeiro
		}
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
		NoProjetoDupla temp;    //criado temp2
		pos = buscaElemento(elemento);
		if(pos == 0){
			removePrimeiro();
		}
		else if (pos > 0){
//			temp1 = atual.proximo;
//			temp2 = atual.anterior;
//			temp1.anterior = temp2;
//			temp2.proximo = temp1;
//		
//			moveParaPosicao(pos-1);
//			atual.proximo=temp1;
//			
//			moveParaPosicao(pos+1);

			temp = atual; /* temporario aponta para o nó encontrado */  
	        if(atual.anterior != null)/* caso haja um nó anterior ao enontrado*/
	        		atual.anterior.proximo = atual.proximo; /* faz o nó anterior apontar para o nó posterior ao encontrado */
	        	if(atual.proximo != null) /* caso haja um nó posterior ao enontrado*/
	        		atual.proximo.anterior = atual.anterior; /* faz o nó posterior apontar para o nó anterior ao encontrado */
		}
	}
	
// Remove o elemento da posição indicada
	public void removeNaPosicao(int pos){
		NoProjetoDupla temp1, temp2;
		moveParaPosicao(pos);
		temp1=atual.proximo;
		temp2=atual.anterior;
		
		temp1.anterior = temp2;
		temp2.proximo = temp1;
		
		moveParaPosicao(pos-1);
		atual.proximo=temp1;
		
		moveParaPosicao(pos+1);
		atual.anterior=temp2;
	}
}
