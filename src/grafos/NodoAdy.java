package grafos;

public class NodoAdy {
	int id;
	int costo;
	
	public NodoAdy(int id, int costo){
		this.id = id;
		this.costo = costo;
	}
	
	public String toString() {
	  return "ID: " + this.id + "Costo: "+ this.costo;
	}
}
