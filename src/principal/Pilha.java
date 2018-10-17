package principal;

public class Pilha {

    private NoPilha topo = null;

    public Pilha() {
    }

    public boolean estaVazia() {
        return topo == null;
    }

    public SorteOuAzar retTopo() {
        return topo.carta;
    }

    public void empilha(SorteOuAzar c) {
        NoPilha novo = new NoPilha(c);
        if (topo == null)
            topo = novo;
        else {
            novo.proximo = topo;
            topo = novo;
        }
    }

    public NoPilha desempilha() {
        if (estaVazia()) {
            return null;
        } else {
            NoPilha retornaCarta = topo;
            this.topo = topo.proximo;
            return retornaCarta;
        }
    }
}