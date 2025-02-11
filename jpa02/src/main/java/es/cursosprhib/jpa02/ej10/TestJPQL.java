package es.cursosprhib.jpa02.ej10;

import java.util.List;

import es.cursosprhib.jpa02.EMF;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class TestJPQL {
public static void main(String[] args) {
	
	EntityManager eManager= EMF.getInstance().createEntityManager();
	
	String jpql = "select j from Jugador j";
	
	TypedQuery<Jugador> query = eManager.createQuery(jpql,Jugador.class);
	
	List<Jugador> jugadores = query.getResultList();
	
	for (Jugador jugador : jugadores) {
		System.out.println(jugador);
		
		for (Equipo equipo : jugador.getEquipos()) {
			System.out.println(equipo);
		}
	}

	
	System.out.println("------------------------------");
	String nombre="Pedro";
	
	jpql = "select j from Jugador j where j.nombreCompleto like :nom";
	
	query= eManager.createQuery(jpql,Jugador.class);
	
	query.setParameter("nom", "%"+nombre+"%");
	
	for (Jugador jugador : query.getResultList()) {
		System.out.println(jugador);
	}
	
}
}
