package es.cursosprhib.jpa02.ej07;

import es.cursosprhib.jpa02.EMF;
import jakarta.persistence.EntityManager;

public class Test {

	public static void main(String[] args) {
		EntityManager em = EMF.getInstance().createEntityManager();
		
		Circulo2 c = em.find(Circulo2.class, 67);
		if (c != null)
			System.out.println(c);
		
		Rectangulo2 r = em.find(Rectangulo2.class, 68);
		if (r != null)
			System.out.println(r);
		
		Circulo2 nuevo = new Circulo2(11.11, 22.22, 33.);
		
		em.persist(nuevo);
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		
		em.close();
	}
}
