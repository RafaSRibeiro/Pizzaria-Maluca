package principal;

public class CartaSorteOuAzar {

	private String texto;

	private int numero;
	
	public CartaSorteOuAzar(String texto, int numero) {
		this.texto = texto;
		this.numero = numero;
	}

	@Override
	public String toString() {
		return texto + "\n" + numero;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
}
