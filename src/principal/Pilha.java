package principal;

public class Pilha {

    private ElementoPilha topo = null;

    public Pilha() {
    }

    public boolean estaVazia() {
        return topo == null;
    }

    public CartaSorteOuAzar retTopo() {
        return topo.getCarta();
    }

    public void empilha(CartaSorteOuAzar c) {
        ElementoPilha novo = new ElementoPilha(c);
        if (topo == null)
            topo = novo;
        else {
            novo.setProximo(topo);
            topo = novo;
        }
    }

    public ElementoPilha desempilha() {
        if (estaVazia()) {
            return null;
        } else {
            ElementoPilha retornaCarta = topo;
            this.topo = topo.getProximo();
            return retornaCarta;
        }
    }
}