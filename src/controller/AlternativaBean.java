package controller;

import java.io.Serializable;
import java.util.Collection;

import javax.ejb.Stateful;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import model.Alternativas;

@Named
@Stateful
@ViewScoped
public class AlternativaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext
	private EntityManager em;

	private Alternativas alternativas;
	private Collection<Alternativas> listaAlternativas;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void init() {
		this.alternativas = new Alternativas();
		CriteriaQuery cQ = em.getCriteriaBuilder().createQuery();
		cQ.select(cQ.from(Alternativas.class));

		listaAlternativas = em.createQuery(cQ).getResultList();
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public Alternativas getAlternativas() {
		return alternativas;
	}

	public void setAlternativas(Alternativas alternativas) {
		this.alternativas = alternativas;
	}

	public Collection<Alternativas> getListaAlternativas() {
		return listaAlternativas;
	}

	public void setListaAlternativas(Collection<Alternativas> listaAlternativas) {
		this.listaAlternativas = listaAlternativas;
	}
	
	

}
