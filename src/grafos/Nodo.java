package grafos;

import java.util.Comparator;

public class Nodo implements Comparator<Nodo> {
  private int id;
  private int grado;
  
  public Nodo(int id, int grado) {
    this.id = id;
    this.grado = grado;
  }
  
  public Nodo(int id) {
    this(id, 0);
  }
  
  public int getGrado() {
    return grado;
  }
  
  public void aumentarGrado(int aumento) {
    grado += aumento;
  }
  
  public void aumentarGrado() {
    this.aumentarGrado(1);
  }
  
  public void quitarGrado() {
    this.aumentarGrado(-1);
  }

  @Override
  public int compare(Nodo n1, Nodo n2) {
    return n1.grado - n2.grado;
  }
  

}
