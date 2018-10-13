package library;

import java.util.ArrayList;

public interface IPizza {
    public void limpaPizza();
    public ArrayList<String> faltamEssesIngredientes();
    public void perdeIngredienteX(String elemento);
    public int ganhaIngredienteAleatorio();
}
