package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import grafos.MatrizSimetrica;

class MatrizSimetricaTest {

  @Test
  void test() {
    MatrizSimetrica matriz = new MatrizSimetrica(5);
    matriz.agregar(1, 2, 3);
    matriz.agregar(1, 3, 4);
    matriz.agregar(3, 2, 2);
    matriz.agregar(4, 3, 10);
    assertEquals(3, matriz.getValue(1, 2));
    assertEquals(4, matriz.getValue(1, 3));
    assertEquals(4, matriz.getValue(3, 1));
    assertEquals(2, matriz.getValue(3, 2));
    
    System.out.println(matriz);

  }

}
