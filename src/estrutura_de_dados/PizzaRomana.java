package estrutura_de_dados;

import java.util.ArrayList;

public class PizzaRomana {
	ListaDupla lista = new ListaDupla();
	int Jogador;
	int qt;
	ArrayList<String>faltam = new ArrayList<>();
	boolean rodadaSemJogar;//Sorte ou Azar

	public boolean isRodadaSemJogar() {
		return rodadaSemJogar;
	}

	public void setRodadaSemJogar(boolean rodadaSemJogar) {
		this.rodadaSemJogar = rodadaSemJogar;
	}

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
		ingredientes.add("Ervilha");
		ingredientes.add("Presunto");
		ingredientes.add("Milho");
		ingredientes.add("Cebola");
		ingredientes.add("Queijo");

		faltam.clear();
		
		for(int j = 0; j<ingredientes.size() ; j++){
			String ing = ingredientes.get(j);
			for(int i = 1; i<this.lista.comprimento()+1; i++){
				if(ing.equalsIgnoreCase(this.lista.elementoNaPosicao(i).getNomeEtapa())){
					this.faltam.add(ingredientes.get(j));
					ingredientes.remove(j);
					j--;
				}
			}
		}

		return faltam;
	}
	
	public PizzaRomana(int jogador){
		lista.inserePrimeiro("queijo", 0);
		lista.inserePrimeiro("cebola", 0);
		lista.inserePrimeiro("milho", 0);
		lista.inserePrimeiro("presunto", 0);
		lista.inserePrimeiro("ervilha", 0);
		setJogador(jogador);
		setQt(5);
		setRodadaSemJogar(false);

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
			verificaSeGanhou();

	}
	
	public void verificaSeGanhou(){
		if(lista.estaVazio()){
			System.out.println("O Jogador "+getJogador() +"ganhou!");
			System.exit(0);
		}
	}

}
