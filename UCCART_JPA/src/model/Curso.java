package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the curso database table.
 * 
 */
@Entity
public class Curso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="curso_id")
	private String cursoId;

	@Column(name="curso_aula")
	private String cursoAula;

	@Column(name="curso_cantactual")
	private Integer cursoCantactual;

	@Column(name="curso_cantmax")
	private Integer cursoCantmax;

	@Column(name="curso_cantmin")
	private Integer cursoCantmin;

	@Column(name="curso_dia1")
	private Integer cursoDia1;

	@Column(name="curso_dia1final")
	private Time cursoDia1final;

	@Column(name="curso_dia1inicio")
	private Time cursoDia1inicio;

	@Column(name="curso_dia2")
	private Integer cursoDia2;

	@Column(name="curso_dia2final")
	private Time cursoDia2final;

	@Column(name="curso_dia2inicio")
	private Time cursoDia2inicio;

	@Temporal(TemporalType.DATE)
	@Column(name="curso_final")
	private Date cursoFinal;

	@Temporal(TemporalType.DATE)
	@Column(name="curso_inicio")
	private Date cursoInicio;

	@Column(name="curso_sede")
	private String cursoSede;

	//bi-directional many-to-one association to Materia
	@ManyToOne
	@JoinColumn(name="curso_codmateria")
	private Materia materia;

	//bi-directional many-to-one association to Profesor
	@ManyToOne
	@JoinColumn(name="curso_codprofesor")
	private Profesor profesor;

	//bi-directional many-to-one association to Nota
	@OneToMany(mappedBy="curso", fetch=FetchType.EAGER)
	private List<Nota> notas;

	//bi-directional many-to-one association to Periodo
	@ManyToOne
	@JoinColumn(name="curso_periodo")
	private Periodo periodo;

	public Curso() {
	}

	public String getCursoId() {
		return this.cursoId;
	}

	public void setCursoId(String cursoId) {
		this.cursoId = cursoId;
	}

	public String getCursoAula() {
		return this.cursoAula;
	}

	public void setCursoAula(String cursoAula) {
		this.cursoAula = cursoAula;
	}

	public Integer getCursoCantactual() {
		return this.cursoCantactual;
	}

	public void setCursoCantactual(Integer cursoCantactual) {
		this.cursoCantactual = cursoCantactual;
	}

	public Integer getCursoCantmax() {
		return this.cursoCantmax;
	}

	public void setCursoCantmax(Integer cursoCantmax) {
		this.cursoCantmax = cursoCantmax;
	}

	public Integer getCursoCantmin() {
		return this.cursoCantmin;
	}

	public void setCursoCantmin(Integer cursoCantmin) {
		this.cursoCantmin = cursoCantmin;
	}

	public Integer getCursoDia1() {
		return this.cursoDia1;
	}

	public void setCursoDia1(Integer cursoDia1) {
		this.cursoDia1 = cursoDia1;
	}

	public Time getCursoDia1final() {
		return this.cursoDia1final;
	}

	public void setCursoDia1final(Time cursoDia1final) {
		this.cursoDia1final = cursoDia1final;
	}

	public Time getCursoDia1inicio() {
		return this.cursoDia1inicio;
	}

	public void setCursoDia1inicio(Time cursoDia1inicio) {
		this.cursoDia1inicio = cursoDia1inicio;
	}

	public Integer getCursoDia2() {
		return this.cursoDia2;
	}

	public void setCursoDia2(Integer cursoDia2) {
		this.cursoDia2 = cursoDia2;
	}

	public Time getCursoDia2final() {
		return this.cursoDia2final;
	}

	public void setCursoDia2final(Time cursoDia2final) {
		this.cursoDia2final = cursoDia2final;
	}

	public Time getCursoDia2inicio() {
		return this.cursoDia2inicio;
	}

	public void setCursoDia2inicio(Time cursoDia2inicio) {
		this.cursoDia2inicio = cursoDia2inicio;
	}

	public Date getCursoFinal() {
		return this.cursoFinal;
	}

	public void setCursoFinal(Date cursoFinal) {
		this.cursoFinal = cursoFinal;
	}

	public Date getCursoInicio() {
		return this.cursoInicio;
	}

	public void setCursoInicio(Date cursoInicio) {
		this.cursoInicio = cursoInicio;
	}

	public String getCursoSede() {
		return this.cursoSede;
	}

	public void setCursoSede(String cursoSede) {
		this.cursoSede = cursoSede;
	}

	public Materia getMateria() {
		return this.materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public Profesor getProfesor() {
		return this.profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public List<Nota> getNotas() {
		return this.notas;
	}

	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}

	public Periodo getPeriodo() {
		return this.periodo;
	}

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}

}