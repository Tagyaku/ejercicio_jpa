package es.cursosprhib.mediosdepago.persistencia;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import es.cursosprhib.mediosdepago.modelo.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class ClienteDaoImpl implements ClienteDaoCustom{
	
	@PersistenceContext
	EntityManager em;
	
	
	@Autowired
	@Lazy
	ClienteDao cliDao;

	@Override
	public Map<String, Cliente> getClientesMapnif() {
		String jpql="select c from Cliente c";
		List<Cliente> clientes= em.createQuery(jpql, Cliente.class).getResultList();
		Map<String, Cliente> resu= new HashMap<>();
		for (Cliente cliente : clientes) {
			resu.put(cliente.getNif(), cliente);
		}
		
		return resu;
	}

}
