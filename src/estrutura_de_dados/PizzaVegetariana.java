package estrutura_de_dados;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class PizzaVegetariana {
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
		ingredientes.add("Ovos");
		ingredientes.add("Cebola");
		ingredientes.add("Ervilha");
		ingredientes.add("Tomate");
		ingredientes.add("Brocolis");

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
	
	public PizzaVegetariana(int jogador){
		lista.inserePrimeiro("brocolis", 0);
		lista.inserePrimeiro("tomate", 0);
		lista.inserePrimeiro("ervilha", 0);
		lista.inserePrimeiro("cebola", 0);
		lista.inserePrimeiro("ovos", 0);
		setJogador(jogador);
		setQt(5);
		setRodadaSemJogar(false);

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
		if(lista.buscaElemento(elemento) > -1){
			lista.removeElemento(elemento);
			setQt(getQt()-1);
			System.out.println("O Jogador "+ getJogador() + " pegou "+elemento + "!");
		}
		verificaSeGanhou();
}
	
	public int ganhaIngredienteAleatorio(){
		Random n = new Random();
		int num;
		while(true){
			if(getQt() == 5){
				System.out.println("Sua Pizza ja esta vazia!");
				return 1;
			}
			num = n.nextInt(5);
			if(lista.buscaElemento("brocolis") == -1 && num == 0){
				lista.inserePrimeiro("brocolis", 0);
				System.out.println("O jogador "+getJogador()+" perdeu brocolis");
				setQt(getQt()+1);

				return 1;
			}
			if(lista.buscaElemento("tomate") == -1 && num == 1){
				lista.inserePrimeiro("tomate", 0);
				System.out.println("O jogador "+getJogador()+" perdeu tomate");
				setQt(getQt()+1);

				return 1;
			}
			if(lista.buscaElemento("ervilha") == -1 && num == 2){
				lista.inserePrimeiro("ervilha", 0);
				System.out.println("O jogador "+getJogador()+" perdeu ervilha");
				setQt(getQt()+1);

				return 1;
			}
			if(lista.buscaElemento("cebola") == -1 && num == 3){
				lista.inserePrimeiro("cebola", 0);			
				System.out.println("O jogador "+getJogador()+" perdeu cebola");
				setQt(getQt()+1);

				return 1;
			}
			if(lista.buscaElemento("ovos") == -1 && num == 4){
				lista.inserePrimeiro("ovos", 0);
				System.out.println("O jogador "+getJogador()+" perdeu ovos");
				setQt(getQt()+1);

				return 1;
			}
		}
	}
	
	public void verificaSeGanhou(){
		if(lista.estaVazio()){
			System.out.println("O Jogador "+getJogador() +" ganhou!");
			JOptionPane.showMessageDialog(null, "O Jogador "+getJogador() +" ganhou!");
			System.exit(0);
		}
	}
	
}
