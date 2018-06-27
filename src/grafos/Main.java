package grafos;

public class Main {
  public static void main(String[] args) {
    int tamGrafo = 5;
    GrafoNoDir grafo = new GrafoNoDir(tamGrafo, 0.5);
    System.out.println(grafo);
    for (int i = 0 ; i < tamGrafo ; i++)
      System.out.print(grafo.matriz.getGrado(i)+" ");
  }
}
