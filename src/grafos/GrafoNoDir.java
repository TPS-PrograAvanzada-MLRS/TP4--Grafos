package grafos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Random;

public class GrafoNoDir {
  int[] nodos;
  MatrizAdy matriz;

  // Generador de grafos n partitos.
  public GrafoNoDir(int cantNodos, int nPartito, boolean separador) {
    if (nPartito > cantNodos)
      return;
    nodos = new int[cantNodos];
    for (int i = 0; i < cantNodos; i++)
      nodos[i] = i;
    matriz = new MatrizAdy(cantNodos);
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
  }

  // Generador de grafos regulares dados Cantidad de nodos y prob de conexión
  public GrafoNoDir(int cantNodos, double probArista) {
    nodos = new int[cantNodos];
    for (int i = 0; i < cantNodos; i++)
      nodos[i] = i;
    Random rand = new Random();
    matriz = new MatrizAdy(cantNodos);
    for (int i = 0; i < cantNodos; i++) {
      for (int j = i; j < cantNodos; j++) {
        if (rand.nextDouble() <= probArista)
          matriz.agregar(i, j);
      }
    }
  }

  // Generador de grafos regulares dados Cantidad de nodos y grado.
  public GrafoNoDir(int cantNodos, int grado) {
    nodos = new int[cantNodos];
    for (int i = 0; i < cantNodos; i++)
      nodos[i] = i;
    matriz = new MatrizAdy(cantNodos);
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

  // Grafo dado un archivo.
  public GrafoNoDir(String path) {
    BufferedReader lector;
    try {
      FileReader fr = new FileReader(path);
      lector = new BufferedReader(fr);

      String[] linea = lector.readLine().split(" ");
      int cantNodos = Integer.parseInt(linea[0]);
      int cantAristas = Integer.parseInt(linea[1]);
      nodos = new int[cantNodos];
      for (int i = 0; i < nodos.length; i++)
        nodos[i] = i;
      matriz = new MatrizAdy(cantNodos);
      for (int i = 0; i < cantAristas; i++) {
        linea = lector.readLine().split(" ");
        matriz.agregar(Integer.parseInt(linea[0]) - 1, Integer.parseInt(linea[1]) - 1,
            Integer.parseInt(linea[2]));
      }

      lector.close();
      fr.close();
    } catch (FileNotFoundException e) {
      System.out.println("Ruta de archivo inválida.");
      e.printStackTrace();
    } catch (IOException e) {
      System.out.println("No se pudo leer.");
      e.printStackTrace();
    }
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
    boolean[] nodoColoreado = new boolean[nodos.length]; // array que representa si un nodo tiene color
    int[] colorNodo = new int[nodos.length]; // array que representa el color de un nodo
    int colorActual = 1;

    PriorityQueue<Integer> monticuloMax = new PriorityQueue<Integer>(nodos.length,
        Collections.reverseOrder());
    for (int i = 0; i < nodos.length; i++)
      monticuloMax.add(matriz.getGrado(i));
    int maxGrado = monticuloMax.poll();
    while(!monticuloMax.isEmpty()) {
      pintar(maxGrado, colorNodo, nodos, colorActual);
      for(int i = 0; i < nodos.length ; i++) {
        if( matriz.getGrado(i) == maxGrado && !nodoColoreado[i]) {
          colorNodo[i] = colorActual;
          nodoColoreado[i] = true;
          break;
        }
      }
      for (int i = 0; i < nodos.length ; i++) {
        if(!nodoColoreado[i]) {
          for(int j = 0; j < nodos.length ; j++) {
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
  

  private void pintar(int maxGrado, int[] colores, int[] nodos,int colorActual) {
    for (int i = 0; i < nodos.length; i++) {
      
    }
  }

  public String toString() {
    String out = "";
    for (int i = 0; i < nodos.length; i++)
      out += nodos[i] + " ";
    return "lista de nodos: " + out + "\n" + "Matriz de Adyacencia: \n" + matriz.toString();
  }
}
