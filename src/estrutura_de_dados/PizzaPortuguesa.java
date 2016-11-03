package estrutura_de_dados;

public class PizzaPortuguesa {
	ListaDupla lista = new ListaDupla();
	int Jogador;
	int qt;
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
	
	public PizzaPortuguesa(int jogador){
		lista.inserePrimeiro("presunto", 0);
		lista.inserePrimeiro("azeitona", 0);
		lista.inserePrimeiro("queijo", 0);
		lista.inserePrimeiro("ovos", 0);
		lista.inserePrimeiro("milho", 0);
		Jogador = jogador;
		setQt(5);

	}
	
	public void limpaPizza(){
		for(int i = 0; i < getQt(); i++)
			lista.removePrimeiro();
		
		lista.inserePrimeiro("presunto", 0);
		lista.inserePrimeiro("azeitona", 0);
		lista.inserePrimeiro("queijo", 0);
		lista.inserePrimeiro("ovos", 0);
		lista.inserePrimeiro("milho", 0);
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
