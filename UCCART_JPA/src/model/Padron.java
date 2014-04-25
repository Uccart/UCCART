package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the padron database table.
 * 
 */
@Entity
public class Padron implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="pad_serial")
	private Integer padSerial;

	//bi-directional many-to-one association to Carrera
	@ManyToOne
	@JoinColumn(name="pad_codcarr")
	private Carrera carrera;

	//bi-directional many-to-one association to Estudiante
	@ManyToOne
	@JoinColumn(name="pad_idestudiante")
	private Estudiante estudiante;

	public Padron() {
	}

	public Integer getPadSerial() {
		return this.padSerial;
	}

	public void setPadSerial(Integer padSerial) {
		this.padSerial = padSerial;
	}

	public Carrera getCarrera() {
		return this.carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	public Estudiante getEstudiante() {
		return this.estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

}