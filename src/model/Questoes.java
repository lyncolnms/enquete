package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Questoes implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	int id;
	@Column(nullable = false, length = 30)
	String questao;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestao() {
		return questao;
	}

	public void setQuestao(String questao) {
		this.questao = questao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((questao == null) ? 0 : questao.hashCode());
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
		Questoes other = (Questoes) obj;
		if (id != other.id)
			return false;
		if (questao == null) {
			if (other.questao != null)
				return false;
		} else if (!questao.equals(other.questao))
			return false;
		return true;
	}

}
