package estrutura_de_dados;

public class PizzaCalabresa {
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


	public PizzaCalabresa(int jogador) {
		lista.inserePrimeiro("calabresa", 0);
		lista.inserePrimeiro("azeitona", 0);
		lista.inserePrimeiro("brocolis", 0);
		lista.inserePrimeiro("ovos", 0);
		lista.inserePrimeiro("ervilha", 0);
		setJogador(jogador);
		setQt(5);
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
	}
	
	public boolean verificaSeGanhou(){
		if(getQt() == 0){
			System.out.println("O Jogador "+getJogador() +"ganhou!");
			return true;
		}
		return false;
	}

}
