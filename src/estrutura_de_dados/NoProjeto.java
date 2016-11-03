package estrutura_de_dados;

public class NoProjeto {

	public String nomeEtapa;
	public int tempo;
	public NoProjeto proximo;

    public NoProjeto(String pnomeEtapa, int ptempo) {
    	nomeEtapa= pnomeEtapa;
    	tempo= ptempo;
    	proximo= null;
    }

	public int getTempo() {
		return tempo;
	}

	public void setTempo(int tempo) {
		this.tempo = tempo;
	}


}