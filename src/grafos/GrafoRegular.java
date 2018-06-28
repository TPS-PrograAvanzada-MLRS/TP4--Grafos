package grafos;

import java.util.Random;

public class GrafoRegular extends Grafo {

  // Generador de grafo regular dado Cantidad de nodos y grado de los mismos.
  public GrafoRegular(int cantNodos, int grado) {
    super(cantNodos);
    if (grado > cantNodos)
      return;
    generar(cantNodos, grado);
  }

  public GrafoRegular(int cantNodos, double probAdy) {
    super(cantNodos);
    if (probAdy > 1.0)
      return;
    int grado = (int) Math.round(probAdy * (cantNodos - 1));
    generar(cantNodos, grado);
  }

  private void generar(int cantNodos, int grado) {
    if( cantNodos % 2 == 1 && grado % 2 == 0)
      return;
    Random rand = new Random();
    for (int i = 0; i < cantNodos; i++) {
      while (matriz.getGrado(i) < grado) {
        int nodoTentativo = rand.nextInt(cantNodos);
        if (matriz.getGrado(nodoTentativo) < grado
            && matriz.getGrado(nodoTentativo) == matriz.getMenorGrado())
          matriz.agregar(i, nodoTentativo);
      }
    }
  }
}
