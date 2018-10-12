package estrutura_de_dados;

import javax.swing.*;

public class UsaListaSimples {

    public static void main(String args[]) {
        NoProjeto no = new NoProjeto("t", 0);
        ListaSimples ls = new ListaSimples();
        String nome = "inicio";
        int tempo;
        while (!nome.equals("fim")) {
            nome = JOptionPane.showInputDialog("Nome Etapa: ");
            if (!nome.equals("fim")) {
                tempo = Integer.parseInt(JOptionPane.showInputDialog("Tempo Duracao: "));
                ls.insereUltimo(nome, tempo);
            }
        }
        JOptionPane.showMessageDialog(null, "listando...");
        no = ls.primeiro();
        while (no.proximo != null) {
            JOptionPane.showMessageDialog(null, "Atual= " + no.nomeEtapa + " - " + no.proximo.nomeEtapa);

            no = no.proximo;
        }
        JOptionPane.showMessageDialog(null, "Atual= " + no.nomeEtapa + " - fim da lista");
    }
}