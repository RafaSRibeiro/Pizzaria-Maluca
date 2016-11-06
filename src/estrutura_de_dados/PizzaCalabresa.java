package estrutura_de_dados;

import java.util.ArrayList;

public class PizzaCalabresa {
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
		ingredientes.add("Ovos");
		ingredientes.add("Brocolis");
		ingredientes.add("Azeitona");
		ingredientes.add("Calabresa");

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
	
	
	public PizzaCalabresa(int jogador) {
		lista.inserePrimeiro("calabresa", 0);
		lista.inserePrimeiro("azeitona", 0);
		lista.inserePrimeiro("brocolis", 0);
		lista.inserePrimeiro("ovos", 0);
		lista.inserePrimeiro("ervilha", 0);
		setJogador(jogador);
		setQt(5);
		setRodadaSemJogar(false);
	}
	

	public void limpaPizza(){
		while(lista.comprimento() != 0){
			System.out.println(lista.comprimento());
			lista.removePrimeiro();
		}
		
		lista.inserePrimeiro("calabresa", 0);
		lista.inserePrimeiro("azeitona", 0);
		lista.inserePrimeiro("brocolis", 0);
		lista.inserePrimeiro("ovos", 0);
		lista.inserePrimeiro("ervilha", 0);
		
		setQt(5);
	}
	public void perdeIngredienteX(String elemento) {
			lista.removeElemento(elemento);
			setQt(getQt()-1);
			verificaSeGanhou();
	}
	
	public void verificaSeGanhou(){
		if(getQt() == 0){
			System.out.println("O Jogador "+getJogador() +"ganhou!");
			System.exit(0);
		}
	}

}
