package es.cursosprhib.jpa03ejerciciojpa.consultas;

import java.util.List;

import es.cursosprhib.jpa03.EMF;
import es.cursosprhib.jpa03ejerciciojpa.modelo.Cliente;
import es.cursosprhib.jpa03ejerciciojpa.modelo.Producto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class Consulta6 {
	public static void main(String[] args) {
		
		
		EntityManager eManager = EMF.getInstance().createEntityManager();
		
		//Listar todos los productos que no han sido comprados nunca
		System.out.println("1--------------------------------");
		String categoria= "5";
		
		String jpqlString = "select p from Producto p left join p.clientes c where c is NULL";
		
		TypedQuery<Producto> query = eManager.createQuery(jpqlString,Producto.class);
		
		//query.setParameter("cat", categoria);
		
		List<Producto> productos = query.getResultList();
		
		for (Producto producto : productos) {
			System.out.println(producto);
		}
		
		

		
		
		
		
		
		
		
		
	}
}
