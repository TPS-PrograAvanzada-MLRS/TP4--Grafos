package grafos;

public class MontMin {
  
  int[] monticulo;
  int sigPos = 1;
  
  public MontMin(int size) {
    monticulo = new int[size];
  }
  
  public void insertar(int numero) {
    if( sigPos >= monticulo.length)
      return;
    
    monticulo[sigPos] = numero;
    int arrPtr = sigPos;
    while(arrPtr != 1 && monticulo[arrPtr/2] > monticulo[arrPtr]) {
      swap(monticulo, arrPtr , arrPtr/2);
      arrPtr /= 2;
    }
    sigPos++;
  }
  
  private void swap(int[] monticulo, int posX, int posY) {
    int aux = monticulo[posX];
    monticulo[posX] = monticulo[posY];
    monticulo[posY] = aux;
  }

  public int extraer() {
    int top = monticulo[1];
    sigPos--;
    monticulo[1] = monticulo[sigPos];
    int derecho = 3;
    int arrPtr = 1;
    while(derecho <= this.size()) {
      int menor = monticulo[arrPtr*2]<monticulo[arrPtr*2+1]?arrPtr*2:arrPtr*2+1;
      if( monticulo[arrPtr] > monticulo[menor]) {
        swap(monticulo, arrPtr, menor);
        arrPtr = menor;
        derecho = menor*2+1;
      }
      else
        return top;
    }
    if(arrPtr*2 <= this.size() && monticulo[arrPtr] > monticulo[arrPtr*2])
      swap(monticulo, arrPtr, arrPtr*2);
    return top;
  }
  
  public boolean isEmpty() {
    if(sigPos == 1)
      return true;
    return false;
  }
  
  public int size() {
    return sigPos -1;
  }
  
  public String toString() {
    if(this.isEmpty())
      return "Vacio";
    String out = "";
    for(int i = 1 ; i < sigPos ; i ++)
      out += monticulo[i] + " ";
    return out;
  }
  
}
