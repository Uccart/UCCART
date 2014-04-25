package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the carrera database table.
 * 
 */
@Entity
public class Carrera implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="carr_cod")
	private String carrCod;
	
	@Column(name="carr_credmax")
	private Integer carrCredmax;

	@Column(name="carr_nombre")
	private String carrNombre;

	//bi-directional many-to-one association to Padron
	@OneToMany(mappedBy="carrera", fetch=FetchType.EAGER)
	private List<Padron> padrons;

	//bi-directional many-to-one association to Plan
	@OneToMany(mappedBy="carrera", fetch=FetchType.EAGER)
	private List<Plan> plans;

	//bi-directional many-to-one association to Requisito
	@OneToMany(mappedBy="carrera", fetch=FetchType.EAGER)
	private List<Requisito> requisitos;

	public Carrera() {
	}

	public String getCarrCod() {
		return this.carrCod;
	}

	public void setCarrCod(String carrCod) {
		this.carrCod = carrCod;
	}
	
	public Integer getCarrCredmax() {
		return this.carrCredmax;
	}

	public void setCarrCredmax(Integer carrCredmax) {
		this.carrCredmax = carrCredmax;
	}

	public String getCarrNombre() {
		return this.carrNombre;
	}

	public void setCarrNombre(String carrNombre) {
		this.carrNombre = carrNombre;
	}
	public List<Padron> getPadrons() {
		return this.padrons;
	}

	public void setPadrons(List<Padron> padrons) {
		this.padrons = padrons;
	}

	public List<Plan> getPlans() {
		return this.plans;
	}

	public void setPlans(List<Plan> plans) {
		this.plans = plans;
	}

	public List<Requisito> getRequisitos() {
		return this.requisitos;
	}

	public void setRequisitos(List<Requisito> requisitos) {
		this.requisitos = requisitos;
	}

}