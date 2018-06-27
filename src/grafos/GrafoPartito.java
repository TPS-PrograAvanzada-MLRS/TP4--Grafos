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
      int cantASacar = cantNodos % nPartito;
      for (int i = 0; i < cantNodos - 1; i++) {
        for (int j = i + 1; j < cantNodos; j++) {
          matriz.agregar(i, j);
        }
      }
      for (int i = 0; i < cantASacar; i++) {
        matriz.sacar(i, i + 1);
      }
    }
  }

}
