package es.cursosprhib.jpa02.ej05;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class Persona05Id implements Serializable {

	private int nroDoc;
	private char letraDoc;
	
	
	public Persona05Id() {
	}
	
	public Persona05Id(int nroDoc, char letraDoc) {
		this.nroDoc = nroDoc;
		this.letraDoc = letraDoc;
	}
	public int getNroDoc() {
		return nroDoc;
	}
	public void setNroDoc(int nroDoc) {
		this.nroDoc = nroDoc;
	}
	public char getLetraDoc() {
		return letraDoc;
	}
	public void setLetraDoc(char letraDoc) {
		this.letraDoc = letraDoc;
	}
	@Override
	public int hashCode() {
		return Objects.hash(letraDoc, nroDoc);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona05Id other = (Persona05Id) obj;
		return letraDoc == other.letraDoc && nroDoc == other.nroDoc;
	}

	
}
