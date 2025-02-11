package es.cursosprhib.mediosdepago.tests;


import es.cursosprhib.mediosdepago.modelo.Cuenta;
import es.cursosprhib.mediosdepago.modelo.Extracto;
import es.cursosprhib.mediosdepago.modelo.Movimiento;
import es.cursosprhib.mediosdepago.modelo.PersonaFisica;
import es.cursosprhib.mediosdepago.modelo.Tarjeta;
import es.cursosprhib.mediosdepago.modelo.TipoMovimiento;
import jakarta.persistence.EntityManager;

public class Test01 {
public static void main(String[] args) {
	
	EntityManager em = EMF.getInstance().createEntityManager();
	
	TipoMovimiento p = em.find(TipoMovimiento.class, 2);
	
	System.out.println(p);
	
}
}
