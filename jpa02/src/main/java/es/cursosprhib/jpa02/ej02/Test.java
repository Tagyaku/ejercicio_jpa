package es.cursosprhib.jpa02.ej02;

import es.cursosprhib.jpa02.EMF;
import jakarta.persistence.EntityManager;

public class Test {
	public static void main(String[] args) {
		
		EntityManager em = EMF.getInstance().createEntityManager();
		
		Persona02 p = em.find(Persona02.class, 10);
		Persona02 otra = em.find(Persona02.class, 11);
		
		
		p.setApodo("Ramita");
		
		
		
		
		Persona02 nueva = new Persona02();
		nueva.setApellidos("ape");
		nueva.setApodo("apodo");
		nueva.setDni("8989898989");
		nueva.setNombre("nombre");
		nueva.setGenero(Genero.H);
		
		em.getTransaction().begin();
//		em.persist(nueva);
		em.getTransaction().commit();
		
		
		System.out.println(p);
		System.out.println(otra);
		
	}
}
