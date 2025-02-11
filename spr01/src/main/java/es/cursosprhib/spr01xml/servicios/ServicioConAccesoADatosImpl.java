package es.cursosprhib.spr01xml.servicios;

import es.cursosprhib.spr01xml.persistencia.ClienteDao;

public class ServicioConAccesoADatosImpl implements ServicioConAccesoADatos{

	
	private ClienteDao cDao;
	
	
	
	@Override
	public void realizarConsulta() {
		System.out.println("metodo de negocio invocando al dao");
		cDao.consulta();
	}

	@Override
	public ClienteDao getClienteDao() {
		
		return this.cDao;
	}

	@Override
	public void setClienteDao(ClienteDao cDao) {
		
		this.cDao=cDao;
	}

}
