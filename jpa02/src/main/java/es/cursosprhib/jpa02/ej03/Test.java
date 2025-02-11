package es.cursosprhib.jpa02.ej03;

import es.cursosprhib.jpa02.EMF;
import jakarta.persistence.EntityManager;

public class Test {
	public static void main(String[] args) {
		
		EntityManager em = EMF.getInstance().createEntityManager();
		
		Persona03 p = em.find(Persona03.class, 7);
		System.out.println(p);
	}
}
