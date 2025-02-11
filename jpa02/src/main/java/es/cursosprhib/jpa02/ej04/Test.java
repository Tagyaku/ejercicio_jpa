package es.cursosprhib.jpa02.ej04;

import es.cursosprhib.jpa02.EMF;
import jakarta.persistence.EntityManager;

public class Test {
	public static void main(String[] args) {
		EntityManager em = EMF.getInstance().createEntityManager();
		
		Persona04 p = em.find(Persona04.class, new Persona04Id(12121212, 'A'));
		
		if (p != null)
			System.out.println(p);
		
		em.close();
		
		System.out.println(p);
	}
}
