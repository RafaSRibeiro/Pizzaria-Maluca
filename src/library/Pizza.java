package library;

import listas.ListaDupla;

public abstract class Pizza implements IPizza {

    protected boolean rodadaSemJogar;

    protected int jogador;

    protected int quantidade;

    protected ListaDupla ingredientes = new ListaDupla();

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

    public ListaDupla getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(ListaDupla ingredientes) {
        this.ingredientes = ingredientes;
    }

    public static final String cebola = "CEBOLA";
    public static final String calabresa = "CALABRESA";
    public static final String queijo = "QUEIJO";
    public static final String tomate = "TOMATE";
    public static final String ovos = "OVOS";
    public static final String azeitona = "AZEITONA";
    public static final String milho = "MILHO";
    public static final String presunto = "PRESUNTO";
    public static final String brocolis = "BROCOLIS";
    public static final String ervilha = "ERVILHA";

    public boolean precisaIngrediente(String ingrediente) {
        return ingredientes.buscaElemento(ingrediente) != -1;
    }

}
