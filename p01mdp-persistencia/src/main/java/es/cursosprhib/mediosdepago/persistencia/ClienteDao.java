package es.cursosprhib.mediosdepago.persistencia;

import java.util.List;

import es.cursosprhib.mediosdepago.modelo.Cliente;

//Implementar en la clase sólo los siguientes métodos:
//	findAll()
//	findByNombre(...)
//	findByIdEager(...)
public interface ClienteDao extends DaoGenerico<Cliente, Integer>{
	public List<Cliente> findByNombre(String nombre);
	
	public List<Cliente> findAll();
	
	public Cliente findByIdEager(Integer id);

	
}
