package estrutura_de_dados;

import library.Pizza;
import listas.ListaDupla;
import listas.ListaSimples;
import listas.ListaSimplesCartas;
import pizza.*;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class TabuleiroPrincipal {
	static ListaSimples listaJogadores = new ListaSimples();
	static ListaDupla tabuleiro = new ListaDupla();
	static int peao = 0; //posicao de cada jogador
	static PizzaCalabresa calabresa = new PizzaCalabresa(0);
	static PizzaMarguerita marguerita = new PizzaMarguerita(0);
	static PizzaPortuguesa portuguesa = new PizzaPortuguesa(0);
	static PizzaRomana romana = new PizzaRomana(0);
	static PizzaToscana toscana = new PizzaToscana(0);
	static PizzaVegetariana vegetariana = new PizzaVegetariana(0);
	static boolean jogaDadoNovamente = false;
	static Pilha cartas = new Pilha();
	static ListaSimplesCartas cartasSorteOuAzar = new ListaSimplesCartas();

	public static void main(String[] args) {
		int nJogadores = menuJogo();
		
		//Cada Jogador escolhe uma pizza
		for(int i = 1; i<=nJogadores ; i++){
			int pizza = Integer.parseInt(JOptionPane.showInputDialog("Jogador "+ i + "\n"  
					+ "Escolha sua pizza:\n"
					+ "1 - Calabresa(calabresa. azeitona, brócolis, ovo, ervilha)\n"
					+ "2 - Marguerita(calabresa, brócolis, tomate, queijo, milho)\n"
					+ "3 - Portuguesa(presunto, azeitona, queijo, ovo, milho)\n"
					+ "4 - Romana(queijo, cebola, milho, presunto, ervilha)\n"
					+ "5 - Toscana(tomate, presunto, azeitona, calabresa, cebola)\n"
					+ "6 - Vegetariana(brócolis, tomate, ervilha, cebola, ovos)"));
			switch (pizza) {
			case 1:
				if(calabresa.getJogador() != 0){
					System.out.println("Essa Pizza é do jogador " + calabresa.getJogador() + "! Escolha outra.");
					i--;
				}
				else{
					calabresa = new PizzaCalabresa(i);	
				}
				break;
			case 2:
				if(marguerita.getJogador() != 0){
					System.out.println("Essa Pizza é do jogador " + marguerita.getJogador() + "! Escolha outra.");
					i--;
				}
				else
					marguerita = new PizzaMarguerita(i);
				break;
			case 3:
				if(portuguesa.getJogador() != 0){
					System.out.println("Essa Pizza é do jogador " + portuguesa.getJogador() + "! Escolha outra.");
					i--;
				}
				else
					portuguesa = new PizzaPortuguesa(i);
				break;
			case 4:
				if(romana.getJogador() != 0){
					System.out.println("Essa Pizza é do jogador " + romana.getJogador() + "! Escolha outra.");
					i--;
				}
				else
					romana = new PizzaRomana(i);
				break;
			case 5:
				if(toscana.getJogador() != 0){
					System.out.println("Essa Pizza é do jogador " + toscana.getJogador() + "! Escolha outra.");
					i--;
				}
				else
					toscana = new PizzaToscana(i);
				break;
			case 6:
				if(vegetariana.getJogador() != 0){
					System.out.println("Essa Pizza é do jogador " + vegetariana.getJogador() + "! Escolha outra.");
					i--;
				}
				else
					vegetariana = new PizzaVegetariana(i);
				break;
			}
		}
		
		montaTabuleiro();
		
		while(true){
			for(int i = 1; i<= nJogadores; i++){
				if(cartas.estaVazia()){
					System.out.println("Embaralhando as cartas de Sorte ou Azar\n");
					SorteOuAzar();						
				}
				rodada(i);
				
				if(jogaDadoNovamente){//Se o jogador pega a carta de jogar novamente
					i--;
					jogaDadoNovamente = false;
				}
				
				
			}
		}
		
	}
	
	//cria cartas sorte ou azar
	public static void SorteOuAzar(){
		
		//coloca as cartas em uma listasimples primeiro para depois embaralhar
		cartasSorteOuAzar.insereUltimo(new SorteOuAzar("Pegue um ingrediente de sua escolha (Sorte)", 0));
		cartasSorteOuAzar.insereUltimo(new SorteOuAzar("Pegue um ingrediente de sua escolha (Sorte)", 0));
		cartasSorteOuAzar.insereUltimo(new SorteOuAzar("Pegue um ingrediente de sua escolha (Sorte)", 0));
		cartasSorteOuAzar.insereUltimo(new SorteOuAzar("Pegue um ingrediente de sua escolha (Sorte)", 0));
		cartasSorteOuAzar.insereUltimo(new SorteOuAzar("Pegue um ingrediente de sua escolha (Sorte)", 0));

		cartasSorteOuAzar.insereUltimo(new SorteOuAzar("Perca um ingrediente aleatório (Azar)", 4));
		cartasSorteOuAzar.insereUltimo(new SorteOuAzar("Perca um ingrediente aleatório (Azar)", 4));
		cartasSorteOuAzar.insereUltimo(new SorteOuAzar("Perca um ingrediente aleatório (Azar)", 4));
		cartasSorteOuAzar.insereUltimo(new SorteOuAzar("Perca um ingrediente aleatório (Azar)", 4));
		cartasSorteOuAzar.insereUltimo(new SorteOuAzar("Perca um ingrediente aleatório (Azar)", 4));

		cartasSorteOuAzar.insereUltimo(new SorteOuAzar("Pegue dois ingredientes de sua escolha (Sorte)", 1));
		cartasSorteOuAzar.insereUltimo(new SorteOuAzar("Pegue dois ingredientes de sua escolha (Sorte)", 1));
		
		cartasSorteOuAzar.insereUltimo(new SorteOuAzar("Sua pizza queimou, perca todos os ingredientes (Azar)", 5));
		cartasSorteOuAzar.insereUltimo(new SorteOuAzar("Sua pizza queimou, perca todos os ingredientes (Azar)", 5));

		cartasSorteOuAzar.insereUltimo(new SorteOuAzar("Jogue os dados novamente (Sorte)", 2));
		cartasSorteOuAzar.insereUltimo(new SorteOuAzar("Jogue os dados novamente (Sorte)", 2));
		cartasSorteOuAzar.insereUltimo(new SorteOuAzar("Jogue os dados novamente (Sorte)", 2));

		cartasSorteOuAzar.insereUltimo(new SorteOuAzar("Fique sem jogar por 1 rodada (Azar)", 3));
		cartasSorteOuAzar.insereUltimo(new SorteOuAzar("Fique sem jogar por 1 rodada (Azar)", 3));
		cartasSorteOuAzar.insereUltimo(new SorteOuAzar("Fique sem jogar por 1 rodada (Azar)", 3));
	
		
		//pega da lista simples e coloca na pilha aleatoriamente
		for(int i = 0 ; i<20 ; i++){
			Random n = new Random();
			int num = n.nextInt(cartasSorteOuAzar.comprimento());
			SorteOuAzar cartaEscolhida = cartasSorteOuAzar.retornaDaPosicao(num);
			cartas.empilha(cartaEscolhida);
			cartasSorteOuAzar.removeNaPosicao(num);
			
		}	
	}

	private static void pegarIngrediente(int jogador) {
        Pizza pizza = getPizzaByJogador(jogador);

        ArrayList<String> array = pizza.faltamEssesIngredientes();
        String msg = "SORTE OU AZAR\n\n"
                + "Pegue um ingrediente de sua escolha\n"
                + "Esses são os ingredientes que você precisa:\n\n";
        for(int i=0 ; i< array.size()  ; i++){
            msg += array.get(i) + "\n";
        }
        msg += "\nEscolha um (de 1 a " + array.size() + ")";

        try {
            boolean tenteNovamente = true;

            do{
                int op = Integer.parseInt(JOptionPane.showInputDialog(msg));
                for (int i = 0; i<array.size();i++){
                    if(op-1 == i){
                        pizza.perdeIngredienteX(array.get(op-1));
                        tenteNovamente = false;
                    }
                }
                if(tenteNovamente)
                    System.out.println("Opa, numero invalido tente novamente!");

            }while(tenteNovamente);
        } catch (NumberFormatException e) {
            pegarIngrediente(jogador);
        }

    }

    private static Pizza getPizzaByJogador(int jogador) {
        if (calabresa.getJogador() == jogador)
            return calabresa;

        if (marguerita.getJogador() == jogador)
            return marguerita;

        if (portuguesa.getJogador() == jogador)
            return portuguesa;

        if (romana.getJogador() == jogador)
            return romana;

        if (toscana.getJogador() == jogador)
            return toscana;

        if (vegetariana.getJogador() == jogador)
            return vegetariana;

        return null;
    }

	private static void verifica(String posicao, int jogador){
		if(posicao.equalsIgnoreCase("PERDE TUDO")){
			System.out.println(" - PERDE TUDO");

			getPizzaByJogador(jogador).limpaPizza();
            System.out.println("O Jogador "+ jogador + " queimou a pizza e perdeu tudo!" );
		}
		else if(posicao.equalsIgnoreCase("SORTE OU AZAR")){
			System.out.println(" - SORTE OU AZAR");

			NoPilha noCarta = cartas.desempilha();
			SorteOuAzar Ccarta = noCarta.carta;
			int carta = Ccarta.getNumero();
			
			//Pegue um ingrediente de sua escolha
			if(carta == 0){
                pegarIngrediente(jogador);
			}
			
			//Pegue dois ingredientes de sua escolha (Sorte) x2
			if(carta == 1){
				// Primeiro
                pegarIngrediente(jogador);

                // Segundo
                pegarIngrediente(jogador);
			}
			
			//Jogue os dados novamente (Sorte)
			if(carta == 2){
				System.out.println("SORTE OU AZAR\nJogue os dados novamente (Sorte)");
				jogaDadoNovamente = true;
			}
			
			//Fique sem jogar por 1 rodada (Azar)
			if(carta == 3){
			    getPizzaByJogador(jogador).setRodadaSemJogar(true);
                System.out.println("SORTE OU AZAR\nFique sem jogar por 1 rodada (Azar)");
			}
			
			//Perca um ingrediente aleatório (Azar)
			if(carta == 4){
			    getPizzaByJogador(jogador).ganhaIngredienteAleatorio();
			}
			
			//Sua pizza queimou, perca todos os ingredientes (Azar)
			if(carta == 5){
			    getPizzaByJogador(jogador).limpaPizza();
			}
		}
		else{
		    Pizza pizza = getPizzaByJogador(jogador);
			if (pizza.precisaIngrediente(posicao)) {
                pizza.perdeIngredienteX(posicao);
                System.out.println("\nO Jogador " + jogador + " pegou " + posicao + "!");
            } else {
                System.out.println("\nO Jogador "+ jogador + " não precisa de " + posicao + "!" );
            }
		}
	}

	private static void rodada(int jogador){
		if (getPizzaByJogador(jogador).isRodadaSemJogar()) {
			System.out.println("Jogador " + jogador +", essa rodada você não pode jogar!");
			getPizzaByJogador(jogador).setRodadaSemJogar(false);
			return;
		}

		peao = peao + dado(jogador);

		if (peao > 35)
			peao = peao - 35;

		System.out.print("O peão está na posição: " + peao);
		verifica(tabuleiro.moveParaPosicao(peao).getNomeEtapa() , jogador);
	}

	private static int dado(int jogador){
		JOptionPane.showMessageDialog(null, "Jogador " + jogador + " jogue o dado!");
		Random dado = new Random();
		int num = dado.nextInt(6) + 1;
		System.out.println("-Jogador "+ jogador + " tirou " +num+ "!");
		return num;		 
	}
	
	private static void montaTabuleiro(){
		tabuleiro.insereUltimo("PERDE TUDO", 1);
		tabuleiro.insereUltimo("CEBOLA", 2);
		tabuleiro.insereUltimo("SORTE OU AZAR", 3);
		tabuleiro.insereUltimo("CALABRESA", 4);
		tabuleiro.insereUltimo("QUEIJO", 5);
		tabuleiro.insereUltimo("SORTE OU AZAR", 6);
		tabuleiro.insereUltimo("SORTE OU AZAR", 7);
		tabuleiro.insereUltimo("TOMATE", 8);
		tabuleiro.insereUltimo("OVOS", 9);
		tabuleiro.insereUltimo("AZEITONA", 10);
		tabuleiro.insereUltimo("SORTE OU AZAR", 11);
		tabuleiro.insereUltimo("SORTE OU AZAR", 12);
		tabuleiro.insereUltimo("MILHO", 13);
		tabuleiro.insereUltimo("ERVILHA", 14);
		tabuleiro.insereUltimo("SORTE OU AZAR", 15);
		tabuleiro.insereUltimo("PRESUNTO", 16);
		tabuleiro.insereUltimo("TOMATE", 17);
		tabuleiro.insereUltimo("MILHO", 18);
		tabuleiro.insereUltimo("SORTE OU AZAR", 19);
		tabuleiro.insereUltimo("SORTE OU AZAR", 20);
		tabuleiro.insereUltimo("BROCOLIS", 21);
		tabuleiro.insereUltimo("SORTE OU AZAR", 22);
		tabuleiro.insereUltimo("OVOS", 23);
		tabuleiro.insereUltimo("CEBOLA", 24);
		tabuleiro.insereUltimo("SORTE OU AZAR", 25);
		tabuleiro.insereUltimo("CALABRESA", 26);
		tabuleiro.insereUltimo("SORTE OU AZAR", 27);
		tabuleiro.insereUltimo("PRESUNTO", 28);
		tabuleiro.insereUltimo("SORTE OU AZAR", 29);
		tabuleiro.insereUltimo("QUEIJO", 30);
		tabuleiro.insereUltimo("ERVILHA", 31);
		tabuleiro.insereUltimo("SORTE OU AZAR", 32);
		tabuleiro.insereUltimo("BROCOLIS", 33);
		tabuleiro.insereUltimo("AZEITONA", 34);
		tabuleiro.insereUltimo("SORTE OU AZAR", 35);
	}
	
	private static int menuJogo(){		
		
		listaJogadores.inserePrimeiro("j5", 0);
		listaJogadores.inserePrimeiro("j4", 0);
		listaJogadores.inserePrimeiro("j3", 0);
		listaJogadores.inserePrimeiro("j2", 0);
		listaJogadores.inserePrimeiro("j1", 0);
		
		System.out.println("TABULEIRO:\n"
				+ "1 - PERDE TUDO\n"
				+ "2 - CEBOLA\n"
				+ "3 - SORTE OU AZAR\n"
				+ "4 - CALABRESA\n"
				+ "5 - QUEIJO\n"
				+ "6 - SORTE OU AZAR\n"
				+ "7 - SORTE OU AZAR\n"
				+ "8 - TOMATE\n"
				+ "9 - OVOS\n"
				+ "10 - AZEITONA\n"
				+ "11 - SORTE OU AZAR\n"
				+ "12 - SORTE OU AZAR\n"
				+ "13 - MILHO\n"
				+ "14 - ERVILHA\n"
				+ "15 - SORTE OU AZAR\n"
				+ "16 - PRESUNTO\n"
				+ "17 - TOMATE\n"
				+ "18 - MILHO\n"
				+ "19 - SORTE OU AZAR\n"
				+ "20 - SORTE OU AZAR\n"
				+ "21 - BROCOLIS\n"
				+ "22 - SORTE OU AZAR\n"
				+ "23 - OVOS\n"
				+ "24 - CEBOLA\n"
				+ "25 - SORTE OU AZAR\n"
				+ "26 - CALABRESA\n"
				+ "27 - SORTE OU AZAR\n"
				+ "28 - PRESUNTO\n"
				+ "29 - SORTE OU AZAR\n"
				+ "30 - QUEIJO\n"
				+ "31 - ERVILHA\n"
				+ "32 - SORTE OU AZAR\n"
				+ "33 - BROCOLIS\n"
				+ "34 - AZEITONA\n"
				+ "35 - SORTE OU AZAR\n");
		int numJogadores = 0;
		while(numJogadores<2 || numJogadores>5){
            numJogadores = Integer.parseInt(JOptionPane.showInputDialog("Numero de jogadores? (2 à 5)"));
		}
		return numJogadores;
		}
	}

