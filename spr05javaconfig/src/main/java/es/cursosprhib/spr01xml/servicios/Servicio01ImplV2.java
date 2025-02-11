package es.cursosprhib.spr01xml.servicios;

public class Servicio01ImplV2 implements Servicio01{

	
	private String descripcion;
	
	@Override
	public void m1() {
		System.out.println("este metodo lo hace mucho mejor");
		
	}

	@Override
	public String getDescripcion() {
		
		return descripcion;
	}

	@Override
	public void setDescripcion(String descripcion) {
		this.descripcion=descripcion;
		
	}

}
