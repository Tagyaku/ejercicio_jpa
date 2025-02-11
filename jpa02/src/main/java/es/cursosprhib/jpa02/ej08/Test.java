package es.cursosprhib.jpa02.ej08;

import es.cursosprhib.jpa02.EMF;
import jakarta.persistence.EntityManager;

public class Test {
	public static void main(String[] args) {
		
		EntityManager em = EMF.getInstance().createEntityManager();
		
		Persona06 p = em.find(Persona06.class, 6);
		System.out.println(p);
	}
}
