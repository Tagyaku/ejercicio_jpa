package es.cursosprhib.jpa02.ej05;

import es.cursosprhib.jpa02.EMF;
import jakarta.persistence.EntityManager;

public class Test {
	public static void main(String[] args) {
		EntityManager em = EMF.getInstance().createEntityManager();
		
		Persona05 p = em.find(Persona05.class, new Persona05Id(12121212, 'A'));
		
		if (p != null)
			System.out.println(p);
		
		em.close();
		
		System.out.println(p);
	}
}
