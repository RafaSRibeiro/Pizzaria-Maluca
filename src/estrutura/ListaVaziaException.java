package estrutura;

/**
 * Classe que cria um exceção para a lista
 */
public class ListaVaziaException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ListaVaziaException() {
        this("Lista");
    }

    public ListaVaziaException(String name) {
        super(name + " está vazia");
    }
} 

