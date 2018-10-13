package estrutura_de_dados;

public class NoProjetoDupla {

    public String nomeEtapa;

    public int tempo;

    public NoProjetoDupla proximo, anterior;

    public NoProjetoDupla(String pnomeEtapa, int ptempo) {
        nomeEtapa = pnomeEtapa;
        tempo = ptempo;
        proximo = null;
        anterior = null;
    }

    public String getNomeEtapa() {
        return nomeEtapa;
    }

    public void setNomeEtapa(String nomeEtapa) {
        this.nomeEtapa = nomeEtapa;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

}
