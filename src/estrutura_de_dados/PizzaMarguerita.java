package estrutura_de_dados;

import java.util.ArrayList;

public class PizzaMarguerita {
	ListaDupla lista = new ListaDupla();
	int Jogador;
	int qt;
	ArrayList<String>faltam = new ArrayList<>();

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

	public ArrayList<String> faltamEssesIngredientes(){
		ArrayList<String> ingredientes = new ArrayList<>();
		ingredientes.add("Queijo");
		ingredientes.add("Cebola");
		ingredientes.add("Milho");
		ingredientes.add("Presunto");
		ingredientes.add("Ervilha");

		faltam.clear();
		
		for(int j = 0; j<ingredientes.size() ; j++){
			String ing = ingredientes.get(j);
			for(int i = 0; i<lista.comprimento(); i++){
				if(ing.equalsIgnoreCase(lista.elementoNaPosicao(i).getNomeEtapa())){
					faltam.add(ingredientes.get(j));
					ingredientes.remove(j);
					j--;
				}
			}
		}

		return faltam;
	}
	public PizzaMarguerita(	int jogador){
		lista.inserePrimeiro("queijo", 0);
		lista.inserePrimeiro("cebola", 0);
		lista.inserePrimeiro("milho", 0);
		lista.inserePrimeiro("presunto", 0);
		lista.inserePrimeiro("ervilha", 0);
		Jogador = jogador;
		setQt(5);

	}
	

	public void limpaPizza(){
		for(int i = 0; i < getQt(); i++)
			lista.removePrimeiro();
		
		lista.inserePrimeiro("queijo", 0);
		lista.inserePrimeiro("cebola", 0);
		lista.inserePrimeiro("milho", 0);
		lista.inserePrimeiro("presunto", 0);
		lista.inserePrimeiro("ervilha", 0);
		setQt(5);

	}
	
	public void perdeIngredienteX(String elemento) {
			lista.removeElemento(elemento);
			setQt(getQt()-1);

	}
	
	public boolean verificaSeGanhou(){
		if(lista.estaVazio()){
			System.out.println("O Jogador "+getJogador() +"ganhou!");
			return true;
		}
		return false;
	}

}
