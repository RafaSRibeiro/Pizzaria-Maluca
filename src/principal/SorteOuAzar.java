package principal;

public class SorteOuAzar {

	String texto;

	int numero;	
	
	public SorteOuAzar(String texto, int numero) {
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
