package es.cursosprhib.mediosdepago.persistencia;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.cursosprhib.mediosdepago.modelo.Cuenta;
import es.cursosprhib.mediosdepago.modelo.Extracto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

@Repository("ExtractoDao")
public class ExtractoDaoImpl implements ExtractoDao{

	
	private EntityManagerFactory emf;
	
	
	

	@Autowired
	public ExtractoDaoImpl(EntityManagerFactory emf) {
		this.emf=emf;
	}
	@Override
	public Extracto save(Extracto entidad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Extracto> saveAll(Collection<Extracto> entidades) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Extracto entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Collection<Extracto> entidades) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Extracto findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Extracto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Extracto> findAllById(Collection<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Extracto findExtracto(Cuenta cuenta, int anyo, int mes) {
	    EntityManager em = emf.createEntityManager();
	    Extracto resuExtracto;

	    String jpql = "SELECT e FROM Extracto e " +
	                  "JOIN FETCH e.movimientos m " +
	                  "JOIN FETCH m.tipo tm " +
	                  "JOIN FETCH e.cuenta c " +
	                  "JOIN FETCH c.tarjetas t " +
	                  "WHERE e.cuenta = :cuenta " +
	                  "AND e.anyo = :anyo " +
	                  "AND e.mes = :mes";
	    
	    TypedQuery<Extracto> query = em.createQuery(jpql, Extracto.class);
	    query.setParameter("cuenta", cuenta);
	    query.setParameter("anyo", anyo);
	    query.setParameter("mes", mes);

	    try {
	        resuExtracto = query.getSingleResult();
	    } catch (NoResultException e) {
//	        e.printStackTrace();
	        resuExtracto = null;
	    }

	    em.close();
	    return resuExtracto;
	}


}
