package principal;

public class NoCartas {

    private CartaSorteOuAzar carta;

    private NoCartas proximo;

    public NoCartas(CartaSorteOuAzar carta) {
        setCarta(carta);
        proximo = null;
    }

    public CartaSorteOuAzar getCarta() {
        return carta;
    }

    public void setCarta(CartaSorteOuAzar carta) {
        this.carta = carta;
    }

    public NoCartas getProximo() {
        return proximo;
    }

    public void setProximo(NoCartas proximo) {
        this.proximo = proximo;
    }

    @Override
    public String toString() {
        return "NoCartas [carta=" + carta.getTexto();
    }


}
