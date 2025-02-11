package es.cursosprhib.spr01xml.servicios;

public class Servicio01Impl implements Servicio01{

	private String descripcion;
	
	public Servicio01Impl() {
		System.out.println("constructor por defecto de Servicio0Impl");
	}
	
	
	public Servicio01Impl(String descripcion) {
		this.descripcion=descripcion;
		System.out.println("constructor de servicio01Impl(String)");
	}
	public Servicio01Impl(String descripcion, int num) {
		this.descripcion=descripcion;
		System.out.println(num);
		System.out.println("constructor de servicio01Impl(String)");
	}
	
	
	@Override
	public void m1() {
		
		System.out.println("metodo de servicio01Impl");
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
