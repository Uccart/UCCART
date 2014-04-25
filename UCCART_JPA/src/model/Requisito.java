package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the requisito database table.
 * 
 */
@Entity
public class Requisito implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="req_cod")
	private Integer reqCod;

	@Column(name="req_tipo")
	private Boolean reqTipo;

	//bi-directional many-to-one association to Carrera
	@ManyToOne
	@JoinColumn(name="req_carrera")
	private Carrera carrera;

	//bi-directional many-to-one association to Materia
	@ManyToOne
	@JoinColumn(name="req_requisito")
	private Materia materia1;

	//bi-directional many-to-one association to Materia
	@ManyToOne
	@JoinColumn(name="req_materia")
	private Materia materia2;

	public Requisito() {
	}

	public Integer getReqCod() {
		return this.reqCod;
	}

	public void setReqCod(Integer reqCod) {
		this.reqCod = reqCod;
	}

	public Boolean getReqTipo() {
		return this.reqTipo;
	}

	public void setReqTipo(Boolean reqTipo) {
		this.reqTipo = reqTipo;
	}

	public Carrera getCarrera() {
		return this.carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	public Materia getMateria1() {
		return this.materia1;
	}

	public void setMateria1(Materia materia1) {
		this.materia1 = materia1;
	}

	public Materia getMateria2() {
		return this.materia2;
	}

	public void setMateria2(Materia materia2) {
		this.materia2 = materia2;
	}

}