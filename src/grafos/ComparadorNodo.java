package grafos;

import java.util.Comparator;

public class ComparadorNodo implements Comparator<NodoAdy>{

  @Override
  public int compare(NodoAdy arg0, NodoAdy arg1) {
    return arg0.costo - arg1.costo;
  }

}
