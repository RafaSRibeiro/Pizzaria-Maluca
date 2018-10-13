package pizza;

import library.Pizza;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class PizzaRomana extends Pizza {

	ArrayList<String>faltam = new ArrayList<>();

	public ArrayList<String> faltamEssesIngredientes(){
		ArrayList<String> ingredientes = new ArrayList<>();
		ingredientes.add(ervilha);
		ingredientes.add(presunto);
		ingredientes.add(milho);
		ingredientes.add(cebola);
		ingredientes.add(queijo);

		faltam.clear();

		for(int j = 0; j<ingredientes.size() ; j++){
			String ing = ingredientes.get(j);
			for(int i = 1; i<this.getIngredientes().tamanho()+1; i++){
				if(ing.equalsIgnoreCase(this.getIngredientes().elementoNaPosicao(i).getNomeEtapa())){
					this.faltam.add(ingredientes.get(j));
					ingredientes.remove(j);
					j--;
				}
			}
		}

		return faltam;
	}

	private void inicializaIngredientes() {
		getIngredientes().inserePrimeiro(queijo, 0);
		getIngredientes().inserePrimeiro(cebola, 0);
		getIngredientes().inserePrimeiro(milho, 0);
		getIngredientes().inserePrimeiro(presunto, 0);
		getIngredientes().inserePrimeiro(ervilha, 0);
	}

	public PizzaRomana(int jogador){
		inicializaIngredientes();
		setJogador(jogador);
		setQuantidade(5);
		setRodadaSemJogar(false);
	}

	public void limpaPizza(){
		for(int i = 0; i < getQuantidade(); i++)
			getIngredientes().removePrimeiro();

		inicializaIngredientes();
		setQuantidade(5);
	}

	public void perdeIngredienteX(String elemento) {
			if(getIngredientes().buscaElemento(elemento) > -1){
				getIngredientes().removeElemento(elemento);
				setQuantidade(getQuantidade()-1);
			}
			verificaSeGanhou();
	}

	public int ganhaIngredienteAleatorio(){
		Random n = new Random();
		int num;
		while(true){

			if(getQuantidade() == 5 ){
				System.out.println("Sua Pizza ja esta vazia!");
				return 1;
			}
			num = n.nextInt(5);
			if(getIngredientes().buscaElemento("queijo") == -1 && num == 0){
				getIngredientes().inserePrimeiro("queijo", 0);
				System.out.println("O jogador "+getJogador()+" perdeu queijo");
				setQuantidade(getQuantidade()+1);

				return 1;
			}
			if(getIngredientes().buscaElemento("cebola") == -1 && num == 1){
				getIngredientes().inserePrimeiro("cebola", 0);
				System.out.println("O jogador "+getJogador()+" perdeu cebola");
				setQuantidade(getQuantidade()+1);

				return 1;
			}
			if(getIngredientes().buscaElemento("milho") == -1 && num == 2){
				getIngredientes().inserePrimeiro("milho", 0);
				System.out.println("O jogador "+getJogador()+" perdeu milho");
				setQuantidade(getQuantidade()+1);

				return 1;
			}
			if(getIngredientes().buscaElemento("presunto") == -1 && num == 3){
				getIngredientes().inserePrimeiro("presunto", 0);
				System.out.println("O jogador "+getJogador()+" perdeu presunto");
				setQuantidade(getQuantidade()+1);

				return 1;
			}
			if(getIngredientes().buscaElemento("ervilha") == -1 && num == 4){
				getIngredientes().inserePrimeiro("ervilha", 0);
				System.out.println("O jogador "+getJogador()+" perdeu ervilha");
				setQuantidade(getQuantidade()+1);

				return 1;
			}
		}
	}

	public void verificaSeGanhou(){
		if(getIngredientes().isVazio()){
			System.out.println("O Jogador "+getJogador() +" ganhou!");
			JOptionPane.showMessageDialog(null, "O Jogador "+getJogador() +" ganhou!");
			System.exit(0);
		}
	}

}
