package es.cursosprhib.mediosdepago.persistencia;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import es.cursosprhib.mediosdepago.config.PersistenciaConfig;
import es.cursosprhib.mediosdepago.modelo.Cuenta;

@SpringBootTest(classes = PersistenciaConfig.class)

public class TestSpringDI {

	@Autowired
	private ClienteDao cliDao;
	
	@Autowired
	private ExtractoDao eDao;
	
	@Test
	void testClienteDao() {
		assertTrue(cliDao.findAll().size() > 1);
		
	}
	
	@Test
	void testExtractoDao() {
		
		Cuenta c = new Cuenta();
		c.setIdCuenta(2);
		assertNotNull(eDao.findExtracto(c, 2020, 7));
		
		
	}
	
}
