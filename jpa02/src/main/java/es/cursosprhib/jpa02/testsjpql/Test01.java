package es.cursosprhib.jpa02.testsjpql;

import es.cursosprhib.jpa02.EMF;
import es.cursosprhib.jpa02.ej08.Persona06;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class Test01 {
public static void main(String[] args) {
	
	
	EntityManager eManager = EMF.getInstance().createEntityManager();
	
	
	String ciudad = "Madrid";
	//todas las personas que viven en la ciudad de madrid
	
	String jpql = "select p from Persona06 p where p.domicilio.ciudad = :ciudad";
	TypedQuery<Persona06> query = eManager.createQuery(jpql,Persona06.class);
	query.setParameter("ciudad", ciudad);
	
	System.out.println("----------------------------");
	for (Persona06 persona06 : query.getResultList()) {
		System.out.println(persona06);
	}
}
}
