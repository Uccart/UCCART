package model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the profesor database table.
 * 
 */
@Entity
public class Profesor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="personas_id")
	private String profId;

	@Column(name="personas_apellido1")
	private String profApellido1;

	@Column(name="personas_apellido2")
	private String profApellido2;

	@Column(name="personas_correo")
	private String profCorreo;

	@Column(name="prof_gradoacademico")
	private String profGradoacademico;

	@Column(name="personas_nombre")
	private String profNombre;

	@Column(name="personas_telefonocel")
	private String profTelefono;
	
	@Column(name="prof_salario")
	private Float profSalario;

	//bi-directional many-to-one association to Curso
	@OneToMany(mappedBy="profesor", fetch=FetchType.EAGER, cascade = CascadeType.REFRESH)
	private List<Curso> cursos;

	public Profesor() {
	}

	public String getProfId() {
		return this.profId;
	}

	public void setProfId(String profId) {
		this.profId = profId;
	}

	public String getProfApellido1() {
		return this.profApellido1;
	}

	public void setProfApellido1(String profApellido1) {
		this.profApellido1 = profApellido1;
	}

	public String getProfApellido2() {
		return this.profApellido2;
	}

	public void setProfApellido2(String profApellido2) {
		this.profApellido2 = profApellido2;
	}

	public String getProfCorreo() {
		return this.profCorreo;
	}

	public void setProfCorreo(String profCorreo) {
		this.profCorreo = profCorreo;
	}

	public String getProfGradoacademico() {
		return this.profGradoacademico;
	}

	public void setProfGradoacademico(String profGradoacademico) {
		this.profGradoacademico = profGradoacademico;
	}

	public String getProfNombre() {
		return this.profNombre;
	}

	public void setProfNombre(String profNombre) {
		this.profNombre = profNombre;
	}

	public String getProfTelefono() {
		return this.profTelefono;
	}
	

	public void setProfTelefono(String profTelefono) {
		this.profTelefono = profTelefono;
	}
	
	public void setProfSalario(Float profSalario) {
		this.profSalario = profSalario;
	}

	public Float getProfSalario() {
		return this.profSalario;
	}

	public List<Curso> getCursos() {
		return this.cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

}