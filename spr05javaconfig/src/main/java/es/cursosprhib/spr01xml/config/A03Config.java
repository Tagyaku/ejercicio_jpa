package es.cursosprhib.spr01xml.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import es.cursosprhib.spr01xml.persistencia.ClienteDao;
import es.cursosprhib.spr01xml.persistencia.ClienteDaoImpl;
import es.cursosprhib.spr01xml.servicios.ServicioConAccesoADatos;
import es.cursosprhib.spr01xml.servicios.ServicioConAccesoADatosImpl;

@Configuration
@Import({A03Configprod.class,A03ConfigDes.class})
public class A03Config {

	@Bean(name="cDao")
	public ClienteDao cDao(DataSource dSource) {
		
		return new ClienteDaoImpl(dSource);
		
	}
	
	@Bean("neg")
	public ServicioConAccesoADatos neg(ClienteDao cDao) {
		ServicioConAccesoADatos serv = new ServicioConAccesoADatosImpl();
		serv.setClienteDao(cDao);
		return serv;
	}
	
	
}
