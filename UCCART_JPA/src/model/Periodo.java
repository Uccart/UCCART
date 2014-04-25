package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the periodo database table.
 * 
 */
@Entity
public class Periodo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="per_periodo")
	private String perPeriodo;

	@Temporal(TemporalType.DATE)
	@Column(name="per_local")
	private Date perLocal;

	@Temporal(TemporalType.DATE)
	@Column(name="per_web")
	private Date perWeb;

	//bi-directional many-to-one association to Curso
	@OneToMany(mappedBy="periodo", fetch=FetchType.EAGER, cascade = CascadeType.REFRESH)
	private List<Curso> cursos;

	public Periodo() {
	}

	public String getPerPeriodo() {
		return this.perPeriodo;
	}

	public void setPerPeriodo(String perPeriodo) {
		this.perPeriodo = perPeriodo;
	}

	public Date getPerLocal() {
		return this.perLocal;
	}

	public void setPerLocal(Date perLocal) {
		this.perLocal = perLocal;
	}

	public Date getPerWeb() {
		return this.perWeb;
	}

	public void setPerWeb(Date perWeb) {
		this.perWeb = perWeb;
	}

	public List<Curso> getCursos() {
		return this.cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

}