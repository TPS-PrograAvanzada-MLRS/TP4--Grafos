package grafos;

public class GrafoPartito extends Grafo {

  public GrafoPartito(int cantNodos, int nPartito) {
    super(cantNodos);
    if (nPartito > cantNodos)
      return;
    if (nPartito <= cantNodos / 2) {
      int tamGrupo = cantNodos / nPartito;
      if (cantNodos % nPartito != 0)
        tamGrupo += 1;
      for (int h = 0; h < cantNodos; h += tamGrupo) {
        for (int i = h; i < tamGrupo + h; i++) {
          for (int j = h + tamGrupo; j < cantNodos; j++) {
            matriz.agregar(i, j);
          }
        }
      }
    } else {
      int cantGrupos = cantNodos % nPartito;
      
      for (int h = 0; h < cantGrupos * 2; h += 2) {
        for (int i = h; i < 2 + h; i++) {
          for (int j = h + 2; j < nodos.length; j++) {
            matriz.agregar(i, j);
          }
        }
      }
      for ( int h = cantGrupos * 2; h < nodos.length -1; h++) {
        for(int i = h +1; i < nodos.length; i++) {
          matriz.agregar(h, i);
        }
      }
    }
  }

}
