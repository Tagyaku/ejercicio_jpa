package es.cursosprhib.jpa03ejerciciojpa.negocio;

import es.cursosprhib.jpa03ejerciciojpa.modelo.Cliente;
import es.cursosprhib.jpa03ejerciciojpa.modelo.dto.ClienteDto;

public class ClienteMapper {

	public static Cliente toCliente(ClienteDto clienteDto) {
		
		Cliente cliente = new Cliente();
		cliente.setIdPersona(clienteDto.getIdPersona());
		cliente.setApellidos(clienteDto.getApellidos());
		cliente.setNroCliente(clienteDto.getNroCliente());
		return  cliente;
	}
	
	
	public static ClienteDto toClienteDto(Cliente cliente) {
		
		return new ClienteDto(cliente.getIdPersona(), cliente.getApellidos(), cliente.getNroCliente());
		
	}
	
	
}
