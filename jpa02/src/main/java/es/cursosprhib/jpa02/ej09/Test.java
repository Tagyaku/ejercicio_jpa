package es.cursosprhib.jpa02.ej09;

import es.cursosprhib.jpa02.EMF;
import jakarta.persistence.EntityManager;

public class Test {
public static void main(String[] args) {
	EntityManager eManager = EMF.getInstance().createEntityManager();
	
	Partido p = eManager.find(Partido.class, 3);
	
	System.out.println(p);
	
	System.out.println("---------------------------------------");
	Campo c = eManager.find(Campo.class, 1);
	
	System.out.println(c);
	for (Partido partido : c.getPartidos()) {
	System.out.println(partido);	
	}
}
}
