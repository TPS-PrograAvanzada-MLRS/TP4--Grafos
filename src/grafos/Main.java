package grafos;

public class Main {
  public static void main(String[] args) {
    int tamGrafo = 10;
    GrafoNoDir grafo = new GrafoNoDir(tamGrafo, 6, true);
    System.out.println(grafo);
    for (int i = 0 ; i < tamGrafo ; i++)
      System.out.print(grafo.matriz.getGrado(i)+" ");
  }
}
