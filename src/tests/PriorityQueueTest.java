package tests;

import java.util.*;

import grafos.ComparadorNodo;
import grafos.NodoAdy;

public class PriorityQueueTest {

  public static void main(String args[]) {
      // create priority queue
      PriorityQueue< NodoAdy > prq = new PriorityQueue <>(1, new ComparadorNodo());

      prq.add(new NodoAdy(1, 5));
      prq.add(new NodoAdy(2, 7));
      prq.add(new NodoAdy(3, 9));
      prq.add(new NodoAdy(4, 13));
      prq.add(new NodoAdy(5, 2));
      
      //print values
      while (!prq.isEmpty()) {
          System.out.print(prq.poll()+"\n");
      }
  }

}