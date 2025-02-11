package es.cursosprhib.jpa02.ej05;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "persona_03")
public class Persona05 implements Serializable {

	@EmbeddedId
	@AttributeOverride(name = "nroDoc", column = @Column(name = "nrodoc"))
	@AttributeOverride(name = "letraDoc", column = @Column(name = "letradoc"))
	private Persona05Id idPersona;
	private String nombre;
	

	public Persona05Id getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(Persona05Id idPersona) {
		this.idPersona = idPersona;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public int hashCode() {
		return Objects.hash(idPersona);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona05 other = (Persona05) obj;
		return Objects.equals(idPersona, other.idPersona);
	}
	@Override
	public String toString() {
		return "Persona05 [idPersona=" + idPersona + ", nombre=" + nombre + "]";
	}
	
}
