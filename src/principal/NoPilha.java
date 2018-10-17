package principal;

public class NoPilha {

		//atributos
		public SorteOuAzar carta;
		public NoPilha proximo;
		
		//construtor
		public NoPilha(SorteOuAzar c){
			carta = c;
			proximo = null;
		}
		
}
