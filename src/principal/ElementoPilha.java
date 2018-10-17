package principal;

public class ElementoPilha {

    private CartaSorteOuAzar carta;

    private ElementoPilha proximo;

    public ElementoPilha(CartaSorteOuAzar c) {
        carta = c;
        proximo = null;
    }

    public CartaSorteOuAzar getCarta() {
        return carta;
    }

    public void setCarta(CartaSorteOuAzar carta) {
        this.carta = carta;
    }

    public ElementoPilha getProximo() {
        return proximo;
    }

    public void setProximo(ElementoPilha proximo) {
        this.proximo = proximo;
    }
}
