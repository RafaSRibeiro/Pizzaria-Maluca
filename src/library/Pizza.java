package library;

public abstract class Pizza {

    protected boolean rodadaSemJogar;

    protected int jogador;

    protected int quantidade;

    public boolean isRodadaSemJogar() {
        return rodadaSemJogar;
    }

    public void setRodadaSemJogar(boolean rodadaSemJogar) {
        this.rodadaSemJogar = rodadaSemJogar;
    }

    public int getJogador() {
        return jogador;
    }

    public void setJogador(int jogador) {
        this.jogador = jogador;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

}
