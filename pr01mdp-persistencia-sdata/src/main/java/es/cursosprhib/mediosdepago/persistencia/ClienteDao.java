package es.cursosprhib.mediosdepago.persistencia;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import es.cursosprhib.mediosdepago.modelo.Cliente;

public interface ClienteDao  extends JpaRepository<Cliente,Integer>, ClienteDaoCustom{

	
	Cliente findByNif(String nif);
	
	@Query("SELECT c FROM Cliente c JOIN PersonaFisica p on p.idPersona=c.idPersona WHERE p.nombre like %?1% or p.apellido1 like %?1% or p.apellido2 like %?1%")
	public List<ClienteDao> findByNombre(String nombre);
	
	
	@Query("select c from Cliente c left join fetch c.cuentas where c.idPersona = ?1")
	public Cliente findByIdEager(Integer id);
	
	default Optional<Cliente> findById(Integer id){
		return Optional.ofNullable(findByIdEager(id));
	}
	
	@Query(nativeQuery = true,value = "select * from...")
	public List<Cliente> noUsar();
}
