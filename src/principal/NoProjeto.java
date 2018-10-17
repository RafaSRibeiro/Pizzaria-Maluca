package principal;

public class NoProjeto {

    private String nomeEtapa;

    private int tempo;

    private NoProjeto proximo;

    public NoProjeto(String pnomeEtapa, int ptempo) {
        nomeEtapa = pnomeEtapa;
        tempo = ptempo;
        proximo = null;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public String getNomeEtapa() {
        return nomeEtapa;
    }

    public void setNomeEtapa(String nomeEtapa) {
        this.nomeEtapa = nomeEtapa;
    }

    public NoProjeto getProximo() {
        return proximo;
    }

    public void setProximo(NoProjeto proximo) {
        this.proximo = proximo;
    }
}