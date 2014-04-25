package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the materia database table.
 * 
 */
@Entity
public class Materia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="materia_id")
	private String materiaId;

	@Column(name="materia_area")
	private String materiaArea;

	@Column(name="materia_creditos")
	private Integer materiaCreditos;

	@Column(name="materia_lab")
	private Integer materiaLab;

	@Column(name="materia_nombre")
	private String materiaNombre;

	//bi-directional many-to-one association to Curso
	@OneToMany(mappedBy="materia", fetch=FetchType.EAGER)
	private List<Curso> cursos;

	//bi-directional many-to-one association to Plan
	@OneToMany(mappedBy="materia", fetch=FetchType.EAGER)
	private List<Plan> plans;

	//bi-directional many-to-one association to Requisito
	@OneToMany(mappedBy="materia1", fetch=FetchType.EAGER)
	private List<Requisito> requisitos1;

	//bi-directional many-to-one association to Requisito
	@OneToMany(mappedBy="materia2", fetch=FetchType.EAGER)
	private List<Requisito> requisitos2;

	public Materia() {
	}

	public String getMateriaId() {
		return this.materiaId;
	}

	public void setMateriaId(String materiaId) {
		this.materiaId = materiaId;
	}

	public String getMateriaArea() {
		return this.materiaArea;
	}

	public void setMateriaArea(String materiaArea) {
		this.materiaArea = materiaArea;
	}

	public Integer getMateriaCreditos() {
		return this.materiaCreditos;
	}

	public void setMateriaCreditos(Integer materiaCreditos) {
		this.materiaCreditos = materiaCreditos;
	}

	public Integer getMateriaLab() {
		return this.materiaLab;
	}

	public void setMateriaLab(Integer materiaLab) {
		this.materiaLab = materiaLab;
	}

	public String getMateriaNombre() {
		return this.materiaNombre;
	}

	public void setMateriaNombre(String materiaNombre) {
		this.materiaNombre = materiaNombre;
	}

	public List<Curso> getCursos() {
		return this.cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public List<Plan> getPlans() {
		return this.plans;
	}

	public void setPlans(List<Plan> plans) {
		this.plans = plans;
	}

	public List<Requisito> getRequisitos1() {
		return this.requisitos1;
	}

	public void setRequisitos1(List<Requisito> requisitos1) {
		this.requisitos1 = requisitos1;
	}

	public List<Requisito> getRequisitos2() {
		return this.requisitos2;
	}

	public void setRequisitos2(List<Requisito> requisitos2) {
		this.requisitos2 = requisitos2;
	}

}