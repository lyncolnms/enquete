package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Alternativas implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	int id;

	@Column(nullable = false, length = 10)
	String alternativaA;
	@Column(nullable = false, length = 10)
	String alternativaB;
	@Column(nullable = false, length = 10)
	String alternativaC;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAlternativaA() {
		return alternativaA;
	}

	public void setAlternativaA(String alternativaA) {
		this.alternativaA = alternativaA;
	}

	public String getAlternativaB() {
		return alternativaB;
	}

	public void setAlternativaB(String alternativaB) {
		this.alternativaB = alternativaB;
	}

	public String getAlternativaC() {
		return alternativaC;
	}

	public void setAlternativaC(String alternativaC) {
		this.alternativaC = alternativaC;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((alternativaA == null) ? 0 : alternativaA.hashCode());
		result = prime * result
				+ ((alternativaB == null) ? 0 : alternativaB.hashCode());
		result = prime * result
				+ ((alternativaC == null) ? 0 : alternativaC.hashCode());
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alternativas other = (Alternativas) obj;
		if (alternativaA == null) {
			if (other.alternativaA != null)
				return false;
		} else if (!alternativaA.equals(other.alternativaA))
			return false;
		if (alternativaB == null) {
			if (other.alternativaB != null)
				return false;
		} else if (!alternativaB.equals(other.alternativaB))
			return false;
		if (alternativaC == null) {
			if (other.alternativaC != null)
				return false;
		} else if (!alternativaC.equals(other.alternativaC))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

}
