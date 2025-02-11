package es.cursosprhib.jpa01.ejemplo01;

import jakarta.persistence.EntityManager;

public class Test02 {
	public static void main(String[] args) {
		
		EntityManager em = EMF.getInstance().createEntityManager();
		
		Persona p = em.find(Persona.class, 2);
		
		System.out.println(p);
		
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		
		
		System.out.println(p);
	}
}
