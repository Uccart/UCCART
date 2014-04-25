package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the plan database table.
 * 
 */
@Entity
public class Plan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="plan_cod")
	private Integer planCod;

	@Column(name="plan_ciclo")
	private Integer planCiclo;

	//bi-directional many-to-one association to Carrera
	@ManyToOne
	@JoinColumn(name="plan_carrera")
	private Carrera carrera;

	//bi-directional many-to-one association to Materia
	@ManyToOne
	@JoinColumn(name="plan_materia")
	private Materia materia;

	public Plan() {
	}

	public Integer getPlanCod() {
		return this.planCod;
	}

	public void setPlanCod(Integer planCod) {
		this.planCod = planCod;
	}

	public Integer getPlanCiclo() {
		return this.planCiclo;
	}

	public void setPlanCiclo(Integer planCiclo) {
		this.planCiclo = planCiclo;
	}

	public Carrera getCarrera() {
		return this.carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	public Materia getMateria() {
		return this.materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

}