package model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the estudiante database table.
 * 
 */
@Entity
public class Estudiante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="personas_id")
	private String estId;

	@Column(name="personas_apellido1")
	private String estApellido1;

	@Column(name="personas_apellido2")
	private String estApellido2;

	@Column(name="est_becado")
	private Boolean estBecado;

	@Column(name="personas_telefonocel")
	private String estCelular;

	@Column(name="personas_correo")
	private String estCorreo;

	@Column(name="personas_direccion")
	private String estDireccion;

	@Column(name="personas_genero")
	private String estGenero;

	@Temporal(TemporalType.DATE)
	@Column(name="personas_fecha_de_nacimiento")
	private Date estNacimiento;

	@Column(name="personas_nacionalidad")
	private String estNacionalidad;

	@Column(name="personas_nombre")
	private String estNombre;

	@Column(name="est_status")
	private Integer estStatus;

	@Column(name="personas_telefonocasa")
	private String estTelefono;

	@Column(name="est_trabajo")
	private String estTrabajo;

	//bi-directional one-to-one association to Beca
	@OneToOne(mappedBy="estudiante")
	private Beca beca;

	//bi-directional many-to-one association to Cobro
	/*@OneToMany(mappedBy="estudiante", fetch=FetchType.EAGER, cascade = CascadeType.REFRESH)
	private List<Cobro> cobros;*/

	//bi-directional one-to-one association to Titulo
	@OneToOne
	@JoinColumn(name="est_codtitulo", referencedColumnName="tit_codigo", insertable = true, updatable = false)
	private Titulo titulo;

	//bi-directional many-to-one association to Nota
	@OneToMany(mappedBy="estudiante", fetch=FetchType.EAGER, cascade = CascadeType.REFRESH)
	private List<Nota> notas;

	//bi-directional one-to-one association to Contrasena
	@OneToOne(mappedBy="estudiante")
	private Contrasena contrasena;

	//bi-directional many-to-one association to Padron
	@OneToMany(mappedBy="estudiante", fetch=FetchType.EAGER, cascade = CascadeType.REFRESH)
	private List<Padron> padrons;

	public Estudiante() {
	}

	public String getEstId() {
		return this.estId;
	}

	public void setEstId(String estId) {
		this.estId = estId;
	}

	public String getEstApellido1() {
		return this.estApellido1;
	}

	public void setEstApellido1(String estApellido1) {
		this.estApellido1 = estApellido1;
	}

	public String getEstApellido2() {
		return this.estApellido2;
	}

	public void setEstApellido2(String estApellido2) {
		this.estApellido2 = estApellido2;
	}

	public Boolean getEstBecado() {
		return this.estBecado;
	}

	public void setEstBecado(Boolean estBecado) {
		this.estBecado = estBecado;
	}

	public String getEstCelular() {
		return this.estCelular;
	}

	public void setEstCelular(String estCelular) {
		this.estCelular = estCelular;
	}

	public String getEstCorreo() {
		return this.estCorreo;
	}

	public void setEstCorreo(String estCorreo) {
		this.estCorreo = estCorreo;
	}

	public String getEstDireccion() {
		return this.estDireccion;
	}

	public void setEstDireccion(String estDireccion) {
		this.estDireccion = estDireccion;
	}

	public String getEstGenero() {
		return this.estGenero;
	}

	public void setEstGenero(String estGenero) {
		this.estGenero = estGenero;
	}

	public Date getEstNacimiento() {
		return this.estNacimiento;
	}

	public void setEstNacimiento(Date estNacimiento) {
		this.estNacimiento = estNacimiento;
	}

	public String getEstNacionalidad() {
		return this.estNacionalidad;
	}

	public void setEstNacionalidad(String estNacionalidad) {
		this.estNacionalidad = estNacionalidad;
	}

	public String getEstNombre() {
		return this.estNombre;
	}

	public void setEstNombre(String estNombre) {
		this.estNombre = estNombre;
	}

	public Integer getEstStatus() {
		return this.estStatus;
	}

	public void setEstStatus(Integer estStatus) {
		this.estStatus = estStatus;
	}

	public String getEstTelefono() {
		return this.estTelefono;
	}

	public void setEstTelefono(String estTelefono) {
		this.estTelefono = estTelefono;
	}

	public String getEstTrabajo() {
		return this.estTrabajo;
	}

	public void setEstTrabajo(String estTrabajo) {
		this.estTrabajo = estTrabajo;
	}

	public Beca getBeca() {
		return this.beca;
	}

	public void setBeca(Beca beca) {
		this.beca = beca;
	}

	/*public List<Cobro> getCobros() {
		return this.cobros;
	}

	public void setCobros(List<Cobro> cobros) {
		this.cobros = cobros;
	}*/

	public Titulo getTitulo() {
		return this.titulo;
	}

	public void setTitulo(Titulo titulo) {
		this.titulo = titulo;
	}

	public List<Nota> getNotas() {
		return this.notas;
	}

	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}

	public Contrasena getContrasena() {
		return this.contrasena;
	}

	public void setContrasena(Contrasena contrasena) {
		this.contrasena = contrasena;
	}

	public List<Padron> getPadrons() {
		return this.padrons;
	}

	public void setPadrons(List<Padron> padrons) {
		this.padrons = padrons;
	}

}