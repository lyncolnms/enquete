package controller;

import java.io.Serializable;
import java.util.Collection;

import javax.ejb.Stateful;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import model.Questoes;

@Named
@Stateful
@ViewScoped
public class QuestaoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext
	private EntityManager em;

	private Questoes questao;
	private Collection<Questoes> listaQuestao;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void init() {
		this.questao = new Questoes();
		CriteriaQuery cQ = em.getCriteriaBuilder().createQuery();
		cQ.select(cQ.from(Questoes.class));

		listaQuestao = em.createQuery(cQ).getResultList();
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public Questoes getQuestao() {
		return questao;
	}

	public void setQuestao(Questoes questao) {
		this.questao = questao;
	}

	public Collection<Questoes> getListaQuestao() {
		return listaQuestao;
	}

	public void setListaQuestao(Collection<Questoes> listaQuestao) {
		this.listaQuestao = listaQuestao;
	}

}
