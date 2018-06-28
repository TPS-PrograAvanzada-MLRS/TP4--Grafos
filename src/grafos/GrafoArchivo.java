package grafos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class GrafoArchivo extends Grafo {

  public GrafoArchivo(String path) {
    super(0);
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
      matriz = new MatrizSimetrica(cantNodos);
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
}
