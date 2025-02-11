package es.cursosprhib.jpa01.ejemplo01;

import jakarta.persistence.EntityManager;

public class Test01 {
	public static void main(String[] args) {
		
		EntityManager em = EMF.getInstance().createEntityManager();
		
		Persona p = em.find(Persona.class, 1);
		
		System.out.println(p);
		
		p.setApellidos("nuevo apellido");
		
		
		Persona nuevo = new Persona();
		nuevo.setApellidos("ape");
		nuevo.setNombre("nom");
		nuevo.setApodo("apodo");
		nuevo.setDni("999999999");

		em.getTransaction().begin();
//		em.persist(nuevo);
		em.merge(p);
		em.getTransaction().commit();
		
		
		System.out.println(p);
	}
}
