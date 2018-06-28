package grafos;

public class Main {
  public static void main(String[] args) {
    int tamGrafo = 100;
    Grafo grafo = new GrafoAleatorio(tamGrafo, 0.5);
    System.out.println(grafo);
    for (int i = 0; i < tamGrafo; i++)
      System.out.print(grafo.matriz.getGrado(i) + " ");
    System.out.println("------------------");
    System.out.println("Coloreo WP: " + grafo.coloreoWP());
    System.out.println("Coloreo Matula: " + grafo.coloreoMatula());
    System.out.println("Coloreo SA: " + grafo.coloreoSA());
  }
}
