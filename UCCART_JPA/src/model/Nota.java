package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the nota database table.
 * 
 */
@Entity
public class Nota implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private NotaPK id;

	@Column(name="nota_condicion")
	private Integer notaCondicion;

	@Column(name="nota_promedio")
	private Integer notaPromedio;

	//bi-directional many-to-one association to Curso
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name="nota_codcurso", referencedColumnName="curso_id", insertable = false, updatable = false)
	private Curso curso;

	//bi-directional many-to-one association to Estudiante
	@ManyToOne
	@JoinColumn(name="nota_codestudiante", referencedColumnName="est_id", insertable = false, updatable = false)
	private Estudiante estudiante;

	public Nota() {
	}

	public NotaPK getId() {
		return this.id;
	}

	public void setId(NotaPK id) {
		this.id = id;
	}

	public Integer getNotaCondicion() {
		return this.notaCondicion;
	}

	public void setNotaCondicion(Integer notaCondicion) {
		this.notaCondicion = notaCondicion;
	}

	public Integer getNotaPromedio() {
		return this.notaPromedio;
	}

	public void setNotaPromedio(Integer notaPromedio) {
		this.notaPromedio = notaPromedio;
	}

	public Curso getCurso() {
		return this.curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Estudiante getEstudiante() {
		return this.estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

}