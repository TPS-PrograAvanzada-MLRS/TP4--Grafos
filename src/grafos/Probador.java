package grafos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Probador {
  Grafo grafo;
  
  Probador(String ruta) {
    FileReader fr = null;
    BufferedReader lector = null;
    String linea[];
    try {
      fr = new FileReader(ruta);
      lector = new BufferedReader(fr);
      linea = lector.readLine().split(" ");
      int cantNodos = Integer.parseInt(linea[0]);
      int cantAristasIndicadas = Integer.parseInt(linea[1]);
      double adyacenciaIndicada = Double.parseDouble(linea[2]);
      int gradoMaximoIndicado = Integer.parseInt(linea[3]);
      int gradoMinimoIndicado = Integer.parseInt(linea[3]);
      grafo = new Grafo(cantNodos);
      for(int i = 0; i < cantAristasIndicadas; i++) {
        linea = lector.readLine().split(" ");
        grafo.matriz.agregar(Integer.parseInt(linea[0]), Integer.parseInt(linea[1]));
      }
    } catch (IOException e) {;
      e.printStackTrace();
    }
    
  }
  
  
  public static void main(String[] args) {
    String rutaOut = "coloreado.out";
    String rutaIn = "grafo.in";
    FileReader fr = null;
    BufferedReader lector = null;
    String linea[];
    String lineaCOmpleta;
    int colores[];
    try {
      fr = new FileReader(rutaOut);
      lector = new BufferedReader(fr);
      linea = lector.readLine().split(" ");
      int cantNodos = Integer.parseInt(linea[0]);
      colores = new int[cantNodos];
      while((lineaCOmpleta = lector.readLine()) != null) {
        linea = lineaCOmpleta.split(" ");
        int indice = Integer.parseInt(linea[0]);
        int color = Integer.parseInt(linea[1]);
        colores[indice] = color;
      }
      fr = new FileReader(rutaIn);
      lector = new BufferedReader(fr);
      linea = lector.readLine().split(" ");
      int cantAristas = Integer.parseInt(linea[1]);
      boolean bienColoreado = true;
      for (int i = 0; i < cantAristas; i++) {
        linea = lector.readLine().split(" ");
        int indiceOrigen = Integer.parseInt(linea[0]);
        int indiceDestino = Integer.parseInt(linea[1]);
        if (colores[indiceOrigen] == colores[indiceDestino]) {
          bienColoreado = false;
          break;
        }
          
      }
      System.out.println(bienColoreado);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
