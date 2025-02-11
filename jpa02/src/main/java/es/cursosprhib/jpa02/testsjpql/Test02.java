package es.cursosprhib.jpa02.testsjpql;

import es.cursosprhib.jpa02.EMF;
import es.cursosprhib.jpa02.ej08.Persona06;
import es.cursosprhib.jpa02.ej09.Campo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class Test02 {
public static void main(String[] args) {
	
	
	EntityManager eManager = EMF.getInstance().createEntityManager();
	
	
	String partido = "Semifinal";
	//tcampos donde se jugaron partidos con la descripcion que incluya 'Semifinal'
	
	String jpql = "select c from Campo c join c.partidos p where p.partido like :part";
	TypedQuery<Campo> query = eManager.createQuery(jpql,Campo.class);
	query.setParameter("part", "%"+partido+"%");
	
	System.out.println("----------------------------");
	for (Campo campo : query.getResultList()) {
		System.out.println(campo);
	}
}
}
