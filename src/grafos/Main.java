package grafos;

public class Main {
  public static void main(String[] args) {
    int tamGrafo = 1000;
    Grafo grafo = new GrafoAleatorio(500, 80);
    grafo.toArchivo("grafo.in");
    
//    Grafo grafo = new GrafoAleatorio(tamGrafo, 0.5);
//    System.out.println(grafo);
//    for (int i = 0; i < tamGrafo; i++)
//      System.out.print(grafo.matriz.getGrado(i) + " ");
//    System.out.println("\n------------------");
//    grafo.coloreoWP("coloreoWP.out");
//    grafo.coloreoMatula("coloreoMatula.out");
//    grafo.coloreoSA("coloreoSA.out");
  }
}
