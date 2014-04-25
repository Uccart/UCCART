package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the beca database table.
 * 
 */
@Entity
public class Beca implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="beca_idestudiante")
	private String becaIdestudiante;

	@Temporal(TemporalType.DATE)
	@Column(name="beca_inicio")
	private Date becaInicio;

	@Column(name="beca_porcentaje")
	private Integer becaPorcentaje;

	@Column(name="beca_tipo")
	private Integer becaTipo;

	@Temporal(TemporalType.DATE)
	@Column(name="beca_vencimiento")
	private Date becaVencimiento;

	//bi-directional one-to-one association to Estudiante
	@OneToOne
	@JoinColumn(name="beca_idestudiante", referencedColumnName="est_id", insertable = false, updatable = false)
	private Estudiante estudiante;

	public Beca() {
	}

	public String getBecaIdestudiante() {
		return this.becaIdestudiante;
	}

	public void setBecaIdestudiante(String becaIdestudiante) {
		this.becaIdestudiante = becaIdestudiante;
	}

	public Date getBecaInicio() {
		return this.becaInicio;
	}

	public void setBecaInicio(Date becaInicio) {
		this.becaInicio = becaInicio;
	}

	public Integer getBecaPorcentaje() {
		return this.becaPorcentaje;
	}

	public void setBecaPorcentaje(Integer becaPorcentaje) {
		this.becaPorcentaje = becaPorcentaje;
	}

	public Integer getBecaTipo() {
		return this.becaTipo;
	}

	public void setBecaTipo(Integer becaTipo) {
		this.becaTipo = becaTipo;
	}

	public Date getBecaVencimiento() {
		return this.becaVencimiento;
	}

	public void setBecaVencimiento(Date becaVencimiento) {
		this.becaVencimiento = becaVencimiento;
	}

	public Estudiante getEstudiante() {
		return this.estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

}