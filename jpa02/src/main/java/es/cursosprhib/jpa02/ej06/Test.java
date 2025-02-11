package es.cursosprhib.jpa02.ej06;

import es.cursosprhib.jpa02.EMF;
import jakarta.persistence.EntityManager;

public class Test {

	public static void main(String[] args) {
		EntityManager em = EMF.getInstance().createEntityManager();
		
		Circulo c = em.find(Circulo.class, 27);
		if (c != null)
			System.out.println(c);
		
		Rectangulo r = em.find(Rectangulo.class, 26);
		if (r != null)
			System.out.println(r);
		
		Circulo nuevo = new Circulo(11.11, 22.22, 33.);
		
		em.persist(nuevo);
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		
		em.close();
	}
}
