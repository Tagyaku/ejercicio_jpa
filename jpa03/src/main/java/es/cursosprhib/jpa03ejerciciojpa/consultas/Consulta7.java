package es.cursosprhib.jpa03ejerciciojpa.consultas;

import java.util.List;

import es.cursosprhib.jpa03.EMF;
import es.cursosprhib.jpa03ejerciciojpa.modelo.Cliente;
import es.cursosprhib.jpa03ejerciciojpa.modelo.Producto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class Consulta7 {
	public static void main(String[] args) {
		
		
		EntityManager eManager = EMF.getInstance().createEntityManager();
		
		//Listar todos los productos con el precio mayor(pueden ser varios con el mismo precio)
		System.out.println("1--------------------------------");
		//String categoria= "5";
		
		String jpqlString = "select p from Producto p where p.precio = (select max(p2.precio) from Producto p2)";
		
		TypedQuery<Producto> query = eManager.createQuery(jpqlString,Producto.class);
		
		//query.setParameter("cat", categoria);
		
		List<Producto> productos= query.getResultList();
		
		for (Producto producto: productos) {
			System.out.println(producto);
		}
		
		

		
		
		
		
		
		
		
		
	}
}
