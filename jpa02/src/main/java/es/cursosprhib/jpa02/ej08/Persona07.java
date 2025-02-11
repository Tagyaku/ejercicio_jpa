package es.cursosprhib.jpa02.ej08;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

import es.cursosprhib.jpa02.ej02.Genero;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "contacto")
public class Persona07 implements Serializable{

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idcontacto")
	private Integer idPersona;
	
	private String nombre;
	private String apellidos;
	private String apodo;
	
	@OneToOne
	@JoinColumn(name = "iddomicilio") //iddomicilio es la fk de la tabla contacto que apunta a la tabla domicilio
	private Domicilio02 domicilio;
	
	@ElementCollection  /*(fetch = FetchType.EAGER)*/
	@CollectionTable(name = "telefonos", joinColumns = @JoinColumn(name ="idcontacto")) //la tabla donde se almacenan los telefonos se llama telefonos y tiene una columna idcontacto que es la foreignkey a la tabla contacto
	@Column(name = "telefono")
	private Set<String> telefonos;
	
	public Persona07() {
		telefonos = new LinkedHashSet<String>();
	}
	
	
	
	
	
	public Set<String> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(Set<String> telefonos) {
		this.telefonos = telefonos;
	}


	public Integer getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(Integer idPersona) {
		System.out.println("acceso a setIdPersona");
		this.idPersona = idPersona;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		System.out.println("acceso a setNombre");
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getApodo() {
		return apodo;
	}
	public void setApodo(String apodo) {
		this.apodo = apodo;
	}

	

	public Domicilio02 getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(Domicilio02 domicilio) {
		this.domicilio = domicilio;
	}
	public String getNombreCompleto() {
		return nombre + " " + apellidos;
	}


	@Override
	public String toString() {
		return "Persona06 [idPersona=" + idPersona + ", nombre=" + nombre + ", apellidos=" + apellidos + ", apodo="
				+ apodo + ", domicilio=" + domicilio + "]";
	}


	public void addTelefono(String telefono) {
		telefonos.add(telefono);
	}
	
	
}
