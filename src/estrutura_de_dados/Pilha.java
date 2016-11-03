package estrutura_de_dados;

public class Pilha {
	
	private NoPilha topo = null; //o topo da pilha
	
	public Pilha(){}

	public boolean estaVazia(){
		return topo == null;
	}
	
	public SorteOuAzar retTopo(){
		return topo.carta;
	}
	public void empilha(SorteOuAzar c){
		NoPilha novo = new NoPilha(c);
		if(topo == null)
			topo = novo;
		else{
			novo.proximo = topo;
			topo = novo;
		}
	}

	public SorteOuAzar desempilha(){
		SorteOuAzar retornaCarta = topo.carta;
		NoPilha aux = topo;
		topo = topo.proximo;
		aux = null;
		return retornaCarta;
	}
}