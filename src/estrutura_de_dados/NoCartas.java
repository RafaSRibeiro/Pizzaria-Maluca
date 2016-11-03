package estrutura_de_dados;

public class NoCartas {
	public SorteOuAzar carta;
	public NoCartas proximo;

    public NoCartas(SorteOuAzar carta) {
    		setCarta(carta);
    		proximo= null;
    }

	public SorteOuAzar getCarta() {
		return carta;
	}

	public void setCarta(SorteOuAzar carta) {
		this.carta = carta;
	}

	@Override
	public String toString() {
		return "NoCartas [carta=" + carta.texto;
	}





}
