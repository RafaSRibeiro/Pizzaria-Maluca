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

	public NoPilha desempilha(){
		if(estaVazia()){
			return null;
		}
		else{
			NoPilha retornaCarta = topo;
			
			this.topo = topo.proximo;
//			return r;
//			NoPilha aux = topo;
//			topo = topo.proximo;
//			aux = null;
			return retornaCarta;
		}
	}
}