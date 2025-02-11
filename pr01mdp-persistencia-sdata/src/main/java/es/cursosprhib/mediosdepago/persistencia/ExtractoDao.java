package es.cursosprhib.mediosdepago.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import es.cursosprhib.mediosdepago.modelo.Cuenta;
import es.cursosprhib.mediosdepago.modelo.Extracto;

public interface ExtractoDao extends JpaRepository<Extracto	, Integer>{

	@Query("SELECT e FROM Extracto e " +
            "JOIN FETCH e.movimientos m " +
            "JOIN FETCH m.tipo tm " +
            "JOIN FETCH e.cuenta c " +
            "JOIN FETCH c.tarjetas t " +
            "WHERE e.cuenta = ?1 " +
            "AND e.anyo = ?2 " +
            "AND e.mes = ?3")
	 Extracto findExtracto(Cuenta cuenta, int anyo, int mes);
}
