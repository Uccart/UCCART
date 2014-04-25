package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the titulo database table.
 * 
 */
@Entity
public class Titulo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="tit_codigo")
	private Integer titCodigo;

	@Column(name="tit_asiento")
	private Integer titAsiento;

	@Column(name="tit_folio")
	private Integer titFolio;

	@Column(name="tit_tomo")
	private Integer titTomo;

	//bi-directional one-to-one association to Estudiante
	@OneToOne(mappedBy="titulo")
	private Estudiante estudiante;

	public Titulo() {
	}

	public Integer getTitCodigo() {
		return this.titCodigo;
	}

	public void setTitCodigo(Integer titCodigo) {
		this.titCodigo = titCodigo;
	}

	public Integer getTitAsiento() {
		return this.titAsiento;
	}

	public void setTitAsiento(Integer titAsiento) {
		this.titAsiento = titAsiento;
	}

	public Integer getTitFolio() {
		return this.titFolio;
	}

	public void setTitFolio(Integer titFolio) {
		this.titFolio = titFolio;
	}

	public Integer getTitTomo() {
		return this.titTomo;
	}

	public void setTitTomo(Integer titTomo) {
		this.titTomo = titTomo;
	}

	public Estudiante getEstudiante() {
		return this.estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

}