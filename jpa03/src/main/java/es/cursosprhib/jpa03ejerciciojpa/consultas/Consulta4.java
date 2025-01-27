package es.cursosprhib.jpa03ejerciciojpa.consultas;

import java.util.List;

import es.cursosprhib.jpa03.EMF;
import es.cursosprhib.jpa03ejerciciojpa.modelo.Cliente;
import es.cursosprhib.jpa03ejerciciojpa.modelo.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class Consulta4 {
	public static void main(String[] args) {
		
		
		EntityManager eManager = EMF.getInstance().createEntityManager();
		
		//Listar todos los clientes que se han comprado productos de un precio mayor a uno especifico
		System.out.println("1--------------------------------");
		String precio= "1";
		
		String jpqlString = "select c from Cliente c join c.productos p where p.precio > :precio";
		
		TypedQuery<Cliente> query = eManager.createQuery(jpqlString,Cliente.class);
		
		query.setParameter("precio", precio);
		
		List<Cliente> clientes = query.getResultList();
		
		for (Cliente cliente: clientes) {
			System.out.println(cliente);
		}
		
		

		
		
		
		
		
		
		
		
	}
}
