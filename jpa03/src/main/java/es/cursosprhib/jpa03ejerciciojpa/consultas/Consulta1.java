package es.cursosprhib.jpa03ejerciciojpa.consultas;

import java.util.List;

import es.cursosprhib.jpa03.EMF;
import es.cursosprhib.jpa03ejerciciojpa.modelo.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class Consulta1 {
	public static void main(String[] args) {
		
		
		EntityManager eManager = EMF.getInstance().createEntityManager();
		
		//Listar todos los clientes de una categoria parametrizada
		System.out.println("1--------------------------------");
		String categoriaClientes= "VIP";
		
		String jpqlString = "select c from Cliente c where c.categoria = :cat";
		
		TypedQuery<Cliente> query = eManager.createQuery(jpqlString,Cliente.class);
		
		query.setParameter("cat", categoriaClientes);
		
		List<Cliente> clientes = query.getResultList();
		
		for (Cliente cliente : clientes) {
			System.out.println(cliente);
		}
		
		

		
		
		
		
		
		
		
		
	}

}
