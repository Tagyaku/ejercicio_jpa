package es.cursosprhib.jpa03ejerciciojpa.consultas;

import java.util.List;

import es.cursosprhib.jpa03.EMF;
import es.cursosprhib.jpa03ejerciciojpa.modelo.Cliente;
import es.cursosprhib.jpa03ejerciciojpa.modelo.Empleado;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class Consulta2 {
	public static void main(String[] args) {
		
		
		EntityManager eManager = EMF.getInstance().createEntityManager();
		
		//Listar todos los empleados de una categoria parametrizada
		System.out.println("1--------------------------------");
		String categoria= "5";
		
		String jpqlString = "select e from Empleado e where e.categoria.idCategoria = :cat";
		
		TypedQuery<Empleado> query = eManager.createQuery(jpqlString,Empleado.class);
		
		query.setParameter("cat", categoria);
		
		List<Empleado> empleados = query.getResultList();
		
		for (Empleado empleado : empleados) {
			System.out.println(empleado);
		}
		
		

		
		
		
		
		
		
		
		
	}
}
