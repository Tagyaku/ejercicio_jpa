package es.cursosprhib.jpa02.ej06;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("CIRCULO")
public class Circulo extends Figura {

	@Column(name = "r")
	private Double radio;

	public Circulo() {
	}

	public Circulo(Double x, Double y, Double radio) {
		super(x, y);
		this.radio = radio;
	}

	public Double getRadio() {
		return radio;
	}

	public void setRadio(Double radio) {
		this.radio = radio;
	}

	@Override
	public String toString() {
		return "Circulo [radio=" + radio + ", getIdFigura()=" + getIdFigura() + ", getX()=" + getX() + ", getY()="
				+ getY() + "]";
	}
	
	
}
