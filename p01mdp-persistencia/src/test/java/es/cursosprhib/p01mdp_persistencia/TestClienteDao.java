package es.cursosprhib.p01mdp_persistencia;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import es.cursosprhib.mediosdepago.modelo.Cliente;
import es.cursosprhib.mediosdepago.persistencia.ClienteDaoImpl;

class TestClienteDao {

	private static ClienteDaoImpl cliDao;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		cliDao = new ClienteDaoImpl(EMFactory.getEmf());
	}

	@Test
	void testFindAll() {
		assertEquals(184, cliDao.findAll().size());
	}

	@Test
	void testFindByNombre() {
		assertEquals(31, cliDao.findByNombre("pe").size());
	}

	@Test
	void testFindByIdEager() {
		Cliente cli = cliDao.findByIdEager(29);
		assertNotNull(cli);
		assertEquals(3, cli.getCuentas().size());
	}
}
