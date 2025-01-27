package es.cursosprhib.jpa03ejerciciojpa.consultas;

import java.util.List;

import es.cursosprhib.jpa03.EMF;
import es.cursosprhib.jpa03ejerciciojpa.modelo.Cliente;
import es.cursosprhib.jpa03ejerciciojpa.modelo.Producto;
import es.cursosprhib.jpa03ejerciciojpa.modelo.Producto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class Consulta5 {
	public static void main(String[] args) {
		
		
		EntityManager eManager = EMF.getInstance().createEntityManager();
		
		//Listar todos los productos que ha comprado un cliente por su id
		System.out.println("1--------------------------------");
		String cliente= "12";
		
		String jpqlString = "select p from Producto p join p.clientes c where c.nroCliente = :cliente";
		
		TypedQuery<Producto> query = eManager.createQuery(jpqlString,Producto.class);
		
		query.setParameter("cliente", cliente);
		
		List<Producto> productos = query.getResultList();
		
		for (Producto producto :productos) {
			System.out.println(producto);
		}
		
		

		
		
		
		
		
		
		
		
	}
}
