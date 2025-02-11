package es.cursosprhib.jpa02.ej06;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("RECTANGULO")
public class Rectangulo extends Figura {

	@Column(name = "l1")
	private Double lado1;
	@Column(name = "l2")
	private Double lado2;
	
	public Rectangulo() {
	}

	public Rectangulo(Double x, Double y, Double lado1, Double lado2) {
		super(x, y);
		this.lado1 = lado1;
		this.lado2 = lado2;
	}

	public Double getLado1() {
		return lado1;
	}

	public void setLado1(Double lado1) {
		this.lado1 = lado1;
	}

	public Double getLado2() {
		return lado2;
	}

	public void setLado2(Double lado2) {
		this.lado2 = lado2;
	}

	@Override
	public String toString() {
		return "Rectangulo [lado1=" + lado1 + ", lado2=" + lado2 + ", getIdFigura()=" + getIdFigura() + ", getX()="
				+ getX() + ", getY()=" + getY() + "]";
	}

	
}
