package es.cursosprhib.spr01xml.servicios;

import es.cursosprhib.spr01xml.persistencia.ClienteDao;

public interface ServicioConAccesoADatos {

	
	public void realizarConsulta();
	
	public ClienteDao getClienteDao();
	
	public void setClienteDao(ClienteDao cDao);
	
	
	
}
