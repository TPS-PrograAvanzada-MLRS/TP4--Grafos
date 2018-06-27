package grafos;

import java.util.Collections;
import java.util.PriorityQueue;

public abstract class Grafo {
  int[] nodos;
  MatrizSimetrica matriz;
  
  public Grafo(int cantNodos) {
    nodos = new int[cantNodos];
    for (int i = 0; i < cantNodos; i++)
      nodos[i] = i;
    matriz = new MatrizSimetrica(cantNodos);
  }
  
  public int[] dijkstra(int inicio) {
    int nodoActual = inicio;

    // Array de String para ruta
    String[] rutas = new String[nodos.length];
    rutas[nodoActual] = "" + (nodoActual);
    // Array de costos iniciado con todos en "infinito"
    int[] resultado = new int[nodos.length];
    for (int i = 0; i < resultado.length; i++) {
      resultado[i] = Integer.MAX_VALUE;
    }
    resultado[nodoActual] = 0;
    // Montículo de mínimo
    PriorityQueue<NodoAdy> monticulo = new PriorityQueue<>(nodos.length, new ComparadorNodo());
    // Array de nodos visitados
    boolean visitados[] = new boolean[nodos.length];
    visitados[nodoActual] = true;

    monticulo.add(new NodoAdy(nodoActual, 0));
    while (!monticulo.isEmpty()) {
      for (int i = 0; i < nodos.length; i++) {
        int distANodo = matriz.getValue(nodoActual, i);
        if (distANodo != 0) {
          if (distANodo + resultado[nodoActual] < resultado[i]) {
            resultado[i] = (distANodo + resultado[nodoActual]);
            rutas[i] = rutas[nodoActual] + "->" + i;
          }
          if (!visitados[i])
            monticulo.add(new NodoAdy(i, distANodo));
        }
      }
      visitados[nodoActual] = true;
      nodoActual = monticulo.poll().id;
    }
    for (int i = 0; i < resultado.length; i++) {
      System.out.println(resultado[i] + " " + rutas[i]);
    }
    return resultado;
  }
  
  public void coloreoWP() {
    boolean[] nodoColoreado = new boolean[nodos.length]; // array que representa si un nodo tiene
                                                         // color
    int[] colorNodo = new int[nodos.length]; // array que representa el color de un nodo
    int colorActual = 1;

    PriorityQueue<Integer> monticuloMax = new PriorityQueue<Integer>(nodos.length,
        Collections.reverseOrder());
    for (int i = 0; i < nodos.length; i++)
      monticuloMax.add(matriz.getGrado(i));
    int maxGrado = monticuloMax.poll();
    while (!monticuloMax.isEmpty()) {
      for (int i = 0; i < nodos.length; i++) {
        if (matriz.getGrado(i) == maxGrado && !nodoColoreado[i]) {
          colorNodo[i] = colorActual;
          nodoColoreado[i] = true;
          break;
        }
      }
      for (int i = 0; i < nodos.length; i++) {
        if (!nodoColoreado[i]) {
          for (int j = 0; j < nodos.length; j++) {
            if (matriz.getValue(i, j) == 0 || colorNodo[j] == colorActual) { // Si tiene un vecino
              // Inserte su lógica aqui.
            }
          }
        }
      }
      colorActual++;
      maxGrado = monticuloMax.poll();
    }
  }

  public String toString() {
    String out = "";
    for (int i = 0; i < nodos.length; i++)
      out += nodos[i] + " ";
    return "lista de nodos: " + out + "\n" + "Matriz de Adyacencia: \n" + matriz.toString();
  }
  
}
