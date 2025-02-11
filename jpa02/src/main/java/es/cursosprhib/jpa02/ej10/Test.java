package es.cursosprhib.jpa02.ej10;

import org.hibernate.internal.build.AllowSysOut;

import es.cursosprhib.jpa02.EMF;
import jakarta.persistence.EntityManager;

public class Test {
	
	public static void main(String[] args) {
		
		

		EntityManager eManager = EMF.getInstance().createEntityManager();
		
		Jugador j =eManager.find(Jugador.class, 10);
		
		System.out.println(j);
		
		System.out.println(j.getEquipos());
		
		
		
	}

	
	
}
