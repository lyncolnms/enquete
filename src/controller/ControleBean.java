package controller;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import model.AlternativaA;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import org.primefaces.model.chart.PieChartModel;

@Named
@Stateful
@ViewScoped
public class ControleBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext
	private EntityManager em;

	private String value;

	private PieChartModel grafico;
	private AlternativaA alternativaA;
	private Collection<AlternativaA> listaAlternativaA;
	private int a;
	private int b;
	private int c;
	private int o;

	@PostConstruct
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void init() {
		this.alternativaA = new AlternativaA();
		CriteriaQuery cQ = em.getCriteriaBuilder().createQuery();
		cQ.select(cQ.from(AlternativaA.class));

		listaAlternativaA = em.createQuery(cQ).getResultList();

		interacao();
	}

	public void interacao() {
		for (AlternativaA alt : listaAlternativaA) {
			if (alt.getDescricao().equals("DotA 2")) {
				this.a = this.a + 1;
			} else if (alt.getDescricao().equals("League of Legends")) {
				this.b = this.b + 1;
			} else if (alt.getDescricao().equals("Battlefield")) {
				this.c = this.c + 1;
			} else {
				this.o = this.o + 1;
			}

		}

		createChartModel();
	}

	public void createChartModel() {
		this.grafico = new PieChartModel();

		grafico.set("DotA 2", this.a);
		grafico.set("League of Legends", this.b);
		grafico.set("Battlfield", this.c);
		grafico.set("Outros", this.o);

		grafico.setTitle("Gráfico");
		grafico.setLegendPosition("w");
		grafico.setShowDataLabels(true);

	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
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

	public PieChartModel getGrafico() {
		return grafico;
	}

	public void setGrafico(PieChartModel grafico) {
		this.grafico = grafico;
	}

	public int getO() {
		return o;
	}

	public void setO(int o) {
		this.o = o;
	}

}
