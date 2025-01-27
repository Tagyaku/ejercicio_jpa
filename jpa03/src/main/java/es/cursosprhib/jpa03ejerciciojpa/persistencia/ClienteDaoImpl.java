package es.cursosprhib.jpa03ejerciciojpa.persistencia;

import java.util.LinkedList;
import java.util.List;

import es.cursosprhib.jpa03.EMF;
import es.cursosprhib.jpa03ejerciciojpa.exceptions.ClientePersistExceptions;
import es.cursosprhib.jpa03ejerciciojpa.modelo.Cliente;
import es.cursosprhib.jpa03ejerciciojpa.modelo.dto.ClienteDto;
import es.cursosprhib.jpa03ejerciciojpa.negocio.ClienteMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

public class ClienteDaoImpl implements ClienteDao{

	private EntityManager em;
	private EntityManagerFactory emf= EMF.getInstance();
	
	
	
	
	@Override
	public Cliente save(Cliente cliente) {

		Cliente saved;
		try {
			em=emf.createEntityManager();
			
			em.getTransaction().begin();
			saved = em.merge(cliente);
			em.getTransaction().commit();
			
			em.close();
		} catch (Exception e) {
			em.getTransaction().rollback();;
			e.printStackTrace();	
			throw new ClientePersistExceptions(e);	
			
		}finally {
			em.close();
		}
		
		return saved;
	}

	@Override
	public void deleteById(Integer id) {		
			delete(getById(id));
	}

	@Override
	public void delete(Cliente cliente) {
		try {
			em=emf.createEntityManager();

			Cliente aEliminar = em.find(Cliente.class, cliente.getIdPersona());

			em.getTransaction().begin();
			em.remove(aEliminar);
			em.getTransaction().commit();
	
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			throw new ClientePersistExceptions(e);
		}
		finally {
			em.close();
		}		
	}

	@Override
	public Cliente getById(Integer id) {
		Cliente cliente;
		try {
			em=emf.createEntityManager();
			cliente=em.find(Cliente.class, id);
			cliente.getProductos().size();
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ClientePersistExceptions(e);
		}
		finally {
			em.close();
		}
		
		
		
		
		return cliente;
	}

	@Override
	public List<ClienteDto> findAll() {
		List<ClienteDto> resu;
		try {
			em=emf.createEntityManager();
			String jpql ="select new es.cursosprhib.jpa03ejerciciojpa.modelo.dto.ClienteDto(c.idPersona, c.apellidos,c.nroCliente) from Cliente c";
			TypedQuery<ClienteDto> q = em.createQuery(jpql,ClienteDto.class);
			resu = q.getResultList();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ClientePersistExceptions(e);
		}
		finally {
			em.close();
		}
		
		return resu;
	}

	@Override
	public List<ClienteDto> findByApellidos(String apellidos) {
		List<Cliente> clis;
		List<ClienteDto> resu = new LinkedList<ClienteDto>();
		try {
			em=emf.createEntityManager();
			String jpql ="select c from Cliente c where c.apellidos like :ape";
			TypedQuery<Cliente> q = em.createQuery(jpql,Cliente.class);
			q.setParameter("ape", "%"+apellidos + "%");
			clis = q.getResultList();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ClientePersistExceptions(e);
		}
		finally {
			em.close();
		}
		
		for (Cliente cliente : clis) {
			resu.add(ClienteMapper.toClienteDto(cliente));
		}
		
		return resu;
	} 

	@Override
	public Cliente getByNroCliente(Integer nroCliente) {
		Cliente cli;
		try {
			em=emf.createEntityManager();
			String jpql ="select c from Cliente c left join fetch c.productos where c.nroCliente = :nroCli";
			TypedQuery<Cliente> q = em.createQuery(jpql,Cliente.class);
			q.setParameter("nroCli", nroCliente);
			cli = q.getSingleResult();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ClientePersistExceptions(e);
		}
		finally {
			em.close();
		}
		

		
		return cli;
	}

}
