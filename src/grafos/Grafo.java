package grafos;

import java.util.AbstractQueue;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

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

  public int coloreoWP() {
    PriorityQueue<Integer> monticuloMax = new PriorityQueue<Integer>(nodos.length,
        Collections.reverseOrder());
    for (int i = 0; i < nodos.length; i++)  
      monticuloMax.add(matriz.getGrado(i));
    return coloreo(monticuloMax);
  }

  public int coloreoMatula() {
    PriorityQueue<Integer> monticuloMin = new PriorityQueue<Integer>(nodos.length);
    for (int i = 0; i < nodos.length; i++)  
      monticuloMin.add(matriz.getGrado(i));
    return coloreo(monticuloMin);
  }

  public int coloreoSA() {
    Queue<Integer> cola = new LinkedList<Integer>();
    for(int i = 0; i < nodos.length; i++) 
      cola.add(nodos[i]);
    Collections.shuffle((List<Integer>) cola);
    return coloreo(cola);
  }
  private int coloreo(Queue<Integer> cola) {
    boolean[] nodoColoreado = new boolean[nodos.length]; // array que dice si un nodo tiene color
    int[] colorNodo = new int[nodos.length]; // array que representa el color de un nodo
    int colorActual = 0;
    int siguiente = cola.poll();
    while (!cola.isEmpty()) {
      for (int i = 0; i < nodos.length; i++) {
        if (matriz.getGrado(i) == siguiente && !nodoColoreado[i]) {
          colorActual++;
          // System.out.println("Empiezo pintando el nodo " + i + " Con el color " +
          // colorActual);
          colorNodo[i] = colorActual;
          nodoColoreado[i] = true;
          break;
        }
      }
      for (int i = 0; i < nodos.length; i++) {
        if (!nodoColoreado[i]) { // Tiene Color?
          boolean sePuedePintar = true;
          for (int j = 0; j < nodos.length; j++) {
            // j es un vecino? Tiene el mismo color?
            if (matriz.getValue(i, j) != 0 && colorNodo[j] == colorActual) {
              sePuedePintar = false;
              break;
            }
          }
          if (sePuedePintar) {
            // System.out.println("Pintando Nodo " + i + " de color " + colorActual);
            colorNodo[i] = colorActual;
            nodoColoreado[i] = true;
          }
        }
      }
      siguiente = cola.poll();
    }
    return colorActual;
  }

  public String toString() {
    String out = "";
    for (int i = 0; i < nodos.length; i++)
      out += nodos[i] + " ";
    return "lista de nodos: " + out + "\n" + "Matriz de Adyacencia: \n" + matriz.toString();
  }

}
