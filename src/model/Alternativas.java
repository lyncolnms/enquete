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

	@Column(length = 30)
	private String alternativa;

	private String outro;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAlternativa() {
		return alternativa;
	}

	public void setAlternativa(String alternativa) {
		this.alternativa = alternativa;
	}

	public String getOutro() {
		return outro;
	}

	public void setOutro(String outro) {
		this.outro = outro;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((alternativa == null) ? 0 : alternativa.hashCode());
		result = prime * result + id;
		result = prime * result + ((outro == null) ? 0 : outro.hashCode());
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
		if (alternativa == null) {
			if (other.alternativa != null)
				return false;
		} else if (!alternativa.equals(other.alternativa))
			return false;
		if (id != other.id)
			return false;
		if (outro == null) {
			if (other.outro != null)
				return false;
		} else if (!outro.equals(other.outro))
			return false;
		return true;
	}

}
