package grafos;

import java.util.Random;

public class GrafoAleatorio extends Grafo{

  // Generador de grafo dado Cantidad de nodos y probabilidad de conexion.
  public GrafoAleatorio(int cantNodos, double prob) {
    super(cantNodos);
    Random rand = new Random();
    for (int i = 0; i < cantNodos; i++) {
      for (int j = i; j < cantNodos; j++) {
        if (rand.nextDouble() <= prob)
          matriz.agregar(i, j);
      }
    }
  }
  
//Generador de grafos dado un porcentaje de adyacencia
 public GrafoAleatorio(int cantNodos, int porcentajeAdy) {
   super(cantNodos);
   int i, j;
   double probAdy = porcentajeAdy / (double) 100;
   Random rand = new Random();
   int cantAristas = (int) Math.round(probAdy * cantNodos * (cantNodos -1)/2);
   int contadorAristas = 0;
   while(contadorAristas < cantAristas) {
     i = rand.nextInt(cantNodos);
     j = rand.nextInt(cantNodos);
     while (j == i)
       j = rand.nextInt(cantNodos);
     if(!matriz.isSet(i, j)) {
       matriz.agregar(i, j);
       contadorAristas++;
     }
   }
 }

}
