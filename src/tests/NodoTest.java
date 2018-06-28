package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import grafos.Nodo;
import junit.framework.Assert;

class NodoTest {

  @Test
  void test() {
    Nodo n1 = new Nodo(1, 3);
    Nodo n2 = new Nodo(2, 4);
    assertEquals(-1, n1.compare(n1, n2));
  }

}
