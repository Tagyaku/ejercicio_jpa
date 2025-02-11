package es.cursosprhib.mediosdepago.persistencia;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import es.cursosprhib.mediosdepago.modelo.Cliente;
import es.cursosprhib.mediosdepago.modelo.Genero;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

@Repository("ClienteDao")
public class ClienteDaoImpl implements ClienteDao {

	private List<Cliente> listaClientes;
	
	//private Cliente cliente;
	
	private EntityManagerFactory emf;
	
	
	
	@Autowired
	public ClienteDaoImpl(EntityManagerFactory emf) {
	    this.emf = emf;
	}

	private EntityManager getEntityManager() {
	    return emf.createEntityManager();
	}

	@Override
	public Cliente save(Cliente entidad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> saveAll(Collection<Cliente> entidades) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Cliente entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Collection<Cliente> entidades) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Cliente findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> findAllById(Collection<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public List<Cliente> findByNombre(String nombre) {
//	    
//	    String sql = "SELECT c.idpersonas, c.nrocliente, p.nombre, p.apellido1, p.apellido2, p.nif, p.sexo, p.municipio, p.provincia FROM clientes c JOIN personas p ON p.idpersonas = c.idpersonas WHERE p.nombre = ?";
//	    
//	    List<Cliente> listaClientes = new ArrayList<>();
//	    
//	    try (Connection con = (Connection) emf.createEntityManager()) {
//	        PreparedStatement ps = con.prepareStatement(sql);
//	        
//	        ps.setString(1, nombre);  
//	        
//	        ResultSet rs = ps.executeQuery();
//	        
//	        while (rs.next()) {
//	            Cliente cliente = new Cliente();
//	            cliente.setIdPersona(rs.getInt("idpersonas"));
//	            cliente.setNombre(rs.getString("nombre"));
//	            cliente.setApellido1(rs.getString("apellido1"));
//	            cliente.setApellido2(rs.getString("apellido2"));
//	            cliente.setNif(rs.getString("nif"));
//	            cliente.setSexo(Genero.valueOf(rs.getString("sexo")));  
//	            cliente.setMunicipio(rs.getString("municipio"));
//	            cliente.setProvincia(rs.getString("provincia"));
//	            cliente.setNroCliente(rs.getInt("nrocliente"));
//	            
//	            listaClientes.add(cliente);  
//	        }
//	    } catch (SQLException e) {
//	        e.printStackTrace();
//	    }
//	    
//	    return listaClientes;
//	}
	@Override
	public List<Cliente> findByNombre(String nombre) {
	    // Usamos JPQL para obtener los clientes basándonos en el nombre
	    String jpql = "SELECT c FROM Cliente c JOIN PersonaFisica p on p.idPersona=c.idPersona WHERE p.nombre like :nombre or p.apellido1 like :nombre or p.apellido2 like :nombre";
	    
	    List<Cliente> listaClientes = emf.createEntityManager()
	                                      .createQuery(jpql, Cliente.class)
	                                      .setParameter("nombre","%"+ nombre+"%")
	                                      .getResultList();
	    
	    return listaClientes;
	}


//	@Override
//	public List<Cliente> findAll() {
//		
//		String sql ="SELECT c.idpersonas, c.nrocliente, p.nombre, p.apellido1, p.apellido2, p.nif, p.sexo, p.municipio, p.provincia FROM clientes c JOIN personas p ON p.idpersonas = c.idpersonas";
//		List<Cliente> listaClientes = new ArrayList<>();
//
//	    try (Connection con = (Connection) emf.createEntityManager()) {
//	        PreparedStatement ps = con.prepareStatement(sql);
//
//	        ResultSet rs = ps.executeQuery();
//
//	        while (rs.next()) {
//	            Cliente cliente = new Cliente();
//
//	            cliente.setIdPersona(rs.getInt("idpersonas"));
//	            cliente.setNombre(rs.getString("nombre"));
//	            cliente.setApellido1(rs.getString("apellido1"));
//	            cliente.setApellido2(rs.getString("apellido2"));
//	            cliente.setNif(rs.getString("nif"));
//	            cliente.setSexo(Genero.valueOf(rs.getString("sexo")));  
//	            cliente.setMunicipio(rs.getString("municipio"));
//	            cliente.setProvincia(rs.getString("provincia"));
//	            cliente.setNroCliente(rs.getInt("nrocliente"));
//
//	            listaClientes.add(cliente);
//	        }
//	    } catch (SQLException e) {
//	        e.printStackTrace();
//	    }
//
//	    return listaClientes;
//	}

	@Override
	public List<Cliente> findAll() {
	    String jpql = "SELECT c FROM Cliente c JOIN PersonaFisica p on p.idPersona=c.idPersona";
	    
	    List<Cliente> listaClientes = emf.createEntityManager()
	                                      .createQuery(jpql, Cliente.class)
	                                      .getResultList();
	    
	    return listaClientes;
	}

	
//	
//	@Override
//	public Cliente findByIdEager(Integer id) {
//		Cliente cliente = new Cliente();
//	    String sql = "SELECT c.idpersonas, c.nrocliente, p.nombre, p.apellido1, p.apellido2, p.nif, p.sexo, p.municipio, p.provincia FROM clientes c JOIN personas p ON p.idpersonas = c.idpersonas WHERE c.idpersonas = ?";
//	    
//	    try (Connection con = (Connection) emf.createEntityManager()) {
//            
//
//	        PreparedStatement ps = con.prepareStatement(sql);
//	        ps.setInt(1, id); 
//
//	        ResultSet rs = ps.executeQuery();
//	        
//	        if (rs.next()) {
//	            cliente.setIdPersona(rs.getInt("idpersonas"));
//	            cliente.setNroCliente(rs.getInt("nrocliente"));	            
//	            cliente.setNombre(rs.getString("nombre"));
//	            cliente.setApellido1(rs.getString("apellido1"));
//	            cliente.setApellido2(rs.getString("apellido2"));
//	            cliente.setNif(rs.getString("nif"));
//	            cliente.setSexo(Genero.valueOf(rs.getString("sexo"))); 
//	            cliente.setMunicipio(rs.getString("municipio"));
//	            cliente.setProvincia(rs.getString("provincia"));
//
//	            return cliente;
//	        }
//	    } catch (SQLException e) {
//	        e.printStackTrace();
//	    }
//
//	    return cliente;
//	}
	
	
	@Override
	public Cliente findByIdEager(Integer id) {
	    String jpql = "SELECT c FROM Cliente c JOIN FETCH PersonaFisica p on p.idPersona=c.idPersona	  WHERE c.idPersona = :id";
	    
	    Cliente cliente = emf.createEntityManager()
	                         .createQuery(jpql, Cliente.class)
	                         .setParameter("id", id)
	                         .getSingleResult();
	    
	    return cliente;
	}


}
