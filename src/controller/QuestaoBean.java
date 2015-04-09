package controller;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.ejb.Stateful;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import model.Alternativas;
import model.Questoes;

@Named
@Stateful
@ViewScoped
public class QuestaoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext
	private EntityManager em;

	private Questoes questao;
	private Collection<String> listaQuestao;
	private String question;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void init() {
		this.questao = new Questoes();
		CriteriaQuery cQ = em.getCriteriaBuilder().createQuery();
		cQ.select(cQ.from(Alternativas.class));

		listaQuestao = em.createQuery(cQ).getResultList();
	}

	public Questoes getQuestao() {
		return questao;
	}

	public void setQuestao(Questoes questao) {
		this.questao = questao;
	}

	public Collection<String> getListaQuestao() {
		return listaQuestao;
	}

	public void setListaQuestao(List<String> listaQuestao) {
		this.listaQuestao = listaQuestao;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

}
