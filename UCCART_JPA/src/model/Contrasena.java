package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the contrasenas database table.
 * 
 */
@Entity
@Table(name="contrasenas")
public class Contrasena implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cont_idestudiante")
	private String contIdestudiante;

	@Column(name="cont_pw")
	private String contPw;

	//bi-directional one-to-one association to Estudiante
	@OneToOne
	@JoinColumn(name="cont_idestudiante", referencedColumnName="personas_id", insertable = false, updatable = false)
	private Estudiante estudiante;

	public Contrasena() {
	}

	public String getContIdestudiante() {
		return this.contIdestudiante;
	}

	public void setContIdestudiante(String contIdestudiante) {
		this.contIdestudiante = contIdestudiante;
	}

	public String getContPw() {
		return this.contPw;
	}

	public void setContPw(String contPw) {
		this.contPw = contPw;
	}

	public Estudiante getEstudiante() {
		return this.estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

}