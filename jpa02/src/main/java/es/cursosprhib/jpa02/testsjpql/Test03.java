package es.cursosprhib.jpa02.testsjpql;

import es.cursosprhib.jpa02.EMF;
import es.cursosprhib.jpa02.ej08.Persona06;
import es.cursosprhib.jpa02.ej08.Persona07;
import es.cursosprhib.jpa02.ej09.Campo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class Test03 {
public static void main(String[] args) {
	
	
	EntityManager eManager = EMF.getInstance().createEntityManager();
	
		
	String jpql = "select p from Persona07 p left join fetch p.telefonos left join fetch p.domicilio";
	TypedQuery<Persona07> query = eManager.createQuery(jpql,Persona07.class);
	
	System.out.println("----------------------------");
	for (Persona07 persona07 : query.getResultList()) {
		System.out.println(persona07);
		System.out.println("----------------------------");

		for (String telefonoString : persona07.getTelefonos()) {
			System.out.println(telefonoString);
		}
		
	}
}
}
