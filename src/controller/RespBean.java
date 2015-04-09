package controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import model.Resposta;

import org.primefaces.model.chart.PieChartModel;

@Named
@ViewScoped
@Stateful
public class RespBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext
	private EntityManager em;

	private PieChartModel pieModel;
	private Resposta resp;
	private List<Resposta> listaResp;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostConstruct
	public void init() {
		CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
		cq.select(cq.from(Resposta.class));
		listaResp = em.createQuery(cq).getResultList();
		createPieModel();
	}

	public PieChartModel getPieModel() {
		return pieModel;
	}

	public void setPieModel(PieChartModel pieModel) {
		this.pieModel = pieModel;
	}

	public Resposta getResp() {
		return resp;
	}

	public void setResp(Resposta resp) {
		this.resp = resp;
	}

	public List<Resposta> getListaResp() {
		return listaResp;
	}

	public void setListaResp(List<Resposta> listaResp) {
		this.listaResp = listaResp;
	}

	private void createPieModel() {
		pieModel = new PieChartModel();

		pieModel.set("oi", 2);
		pieModel.set("hello", 3);
		pieModel.set("olá", 4);
	}

	public void salvar(Resposta resp) {
		try {
			this.em.persist(resp);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.init();
		}
	}
}
