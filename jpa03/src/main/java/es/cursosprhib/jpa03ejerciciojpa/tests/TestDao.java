package es.cursosprhib.jpa03ejerciciojpa.tests;


import java.util.List;

import es.cursosprhib.jpa03ejerciciojpa.modelo.Cliente;
import es.cursosprhib.jpa03ejerciciojpa.modelo.dto.ClienteDto;
import es.cursosprhib.jpa03ejerciciojpa.negocio.ClienteMapper;
import es.cursosprhib.jpa03ejerciciojpa.persistencia.ClienteDao;
import es.cursosprhib.jpa03ejerciciojpa.persistencia.ClienteDaoImpl;

public class TestDao {
public static void main(String[] args) {
	
	
	ClienteDao cDao = new ClienteDaoImpl();
	
	Cliente c = cDao.getById(14);
	System.out.println(c);
	System.out.println(c.getProductos());
	
	System.out.println("----------------------");
	
	Cliente c1 = cDao.getByNroCliente(10987);
	System.out.println(c1);
	System.out.println(c1.getProductos());
	
	System.out.println("-------------------");
	
	List<ClienteDto> clis = cDao.findAll();
	for (ClienteDto clienteDto : clis) {
		System.out.println(clienteDto);
		if (clienteDto.getIdPersona() == 19) {
			Cliente buscado = cDao.getById(clienteDto.getIdPersona());
			System.out.println(buscado);
		}
	}
	
	System.out.println("-------------------");

	List<ClienteDto> clisNuevo = cDao.findByApellidos("ez");
	for (ClienteDto clienteDto : clisNuevo) {
		System.out.println(clienteDto);
		
	}
	
	System.out.println("-------------------");

	//ClienteDto nuevo= new ClienteDto(null, "Perez Perez", 987656);
	//Cliente cliNuevo = cDao.save(ClienteMapper.toCliente(nuevo));
	//System.out.println(cliNuevo);
	System.out.println("-------------------");

	//c.setCategoria("NUEVA");
	//cDao.save(c);
	
	System.out.println("-------------------");

	//cDao.deleteById(40);
	
	
	
	
	
	}
}
