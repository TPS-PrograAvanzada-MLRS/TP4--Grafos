package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;

import grafos.MontMin;

class MontMinTest {

  @Test
  void test() {
    MontMin monticulo = new MontMin(100);
    assertEquals(true, monticulo.isEmpty());
    assertEquals(0, monticulo.size());
    monticulo.insertar(5);
    assertEquals(1, monticulo.size());
    assertEquals(false, monticulo.isEmpty());
    assertEquals(5, monticulo.extraer());
    assertEquals(true, monticulo.isEmpty());
    
    monticulo.insertar(5);
    monticulo.insertar(10);
    monticulo.insertar(1);
    monticulo.insertar(33);
    monticulo.insertar(4);
    
    System.out.println(monticulo);    
    assertEquals(5, monticulo.size());
    
    assertEquals(1, monticulo.extraer());
    System.out.println(monticulo);    
    assertEquals(4, monticulo.extraer());
    System.out.println(monticulo);
    assertEquals(5, monticulo.extraer());
    System.out.println(monticulo);    
    assertEquals(10, monticulo.extraer());
    System.out.println(monticulo);    
    assertEquals(33, monticulo.extraer());
    System.out.println(monticulo);
     
    Random rand = new Random();
    for(int i = 0 ; i < 100 ; i++) {
      int numAlea = rand.nextInt(1000);
      monticulo.insertar(numAlea);
    }
    for(int i = 0 ; i < 100 ; i++) {
      System.out.println(monticulo.extraer());
    }
  }

}
