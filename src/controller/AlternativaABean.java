package controller;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import model.AlternativaA;

@Named
@Stateful
@ViewScoped
public class AlternativaABean implements Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext
	private EntityManager em;

	private AlternativaA alternativaA;
	private Collection<AlternativaA> listaAlternativaA;

	@PostConstruct
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void init() {
		this.alternativaA = new AlternativaA();
		CriteriaQuery cQ = em.getCriteriaBuilder().createQuery();
		cQ.select(cQ.from(AlternativaA.class));

		listaAlternativaA = em.createQuery(cQ).getResultList();
	}

	public AlternativaA getAlternativaA() {
		return alternativaA;
	}

	public void setAlternativaA(AlternativaA alternativaA) {
		this.alternativaA = alternativaA;
	}

	public Collection<AlternativaA> getListaAlternativaA() {
		return listaAlternativaA;
	}

	public void setListaAlternativaA(Collection<AlternativaA> listaAlternativaA) {
		this.listaAlternativaA = listaAlternativaA;
	}

	public void salvar(AlternativaA altenativa) {
		try {
			this.em.persist(altenativa);
			this.em.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.init();
		}
	}

}
