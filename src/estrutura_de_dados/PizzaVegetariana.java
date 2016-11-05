package estrutura_de_dados;

import java.util.ArrayList;

public class PizzaVegetariana {
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
		ingredientes.add("Brocolis");
		ingredientes.add("Tomate");
		ingredientes.add("Ervilha");
		ingredientes.add("Cebola");
		ingredientes.add("Ovos");

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
	
	public PizzaVegetariana(int jogador){
		lista.inserePrimeiro("brocolis", 0);
		lista.inserePrimeiro("tomate", 0);
		lista.inserePrimeiro("ervilha", 0);
		lista.inserePrimeiro("cebola", 0);
		lista.inserePrimeiro("ovos", 0);
		Jogador = jogador;
		setQt(5);

	}
	
	public void limpaPizza(){
		for(int i = 0; i < getQt(); i++)
			lista.removePrimeiro();
		
		lista.inserePrimeiro("brocolis", 0);
		lista.inserePrimeiro("tomate", 0);
		lista.inserePrimeiro("ervilha", 0);
		lista.inserePrimeiro("cebola", 0);
		lista.inserePrimeiro("ovos", 0);
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
