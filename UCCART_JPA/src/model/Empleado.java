package model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
/**
 * The persistent class for the Empleado database table.
 * 
 */

@Entity
@Table(name="empleados")
public class Empleado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="personas_id")
	private String empleadosId ;

	@Column(name="personas_nombre")
	private String empleadosNombre;

	@Column(name="personas_apellido1")
	private String empleadosApellido1;
	
	@Column(name="personas_apellido2")
	private String empleadosApellido2 ;
	
	@Temporal(TemporalType.DATE)
	@Column(name="personas_fecha_de_nacimiento")
	private Date empleadosFechaN;
	
	@Column(name="personas_telefonocasa")
	private String empleadosTelefonoCasa;
	
	@Column(name="personas_telefonocel")
	private String empleadosTelefonoCel;

	@Column(name="personas_direccion")
	private String empleadosDireccion;
	
	@Column(name="personas_genero")
	private String empleadosGenero;
	
	@Column(name="personas_nacionalidad")
	private String empleadosNacionalidad;
	
	@Column(name="personas_correo")
	private String empleadosCorreo;
	
	@Column(name="empleados_salario_bruto")
	private float empleadosSalario;
	
	@Column(name="empleados_puesto")
	private String empleadosPuesto;
	
	
	public Empleado() {
	}

	public String getEmpleadoId() {
		return this.empleadosId;
	}

	public void setEmpleadosId(String empleadosId) {
		this.empleadosId = empleadosId;
	}
	
	public String getEmpleadoNombre() {
		return this.empleadosNombre;
	}

	public void setEmpleadosNombre(String empleadosNombre) {
		this.empleadosNombre = empleadosNombre;
	}
	
	public String getEmpleadosApellido1() {
		return this.empleadosApellido1;
	}

	public void setEmpleadosApellido1(String empleadosApellido1) {
		this.empleadosApellido1 = empleadosApellido1;
	}
	
	public String getEmpleadosApellido2() {
		return this.empleadosApellido2;
	}

	public void setEmpleadosApellido2(String empleadosApellido2) {
		this.empleadosApellido2 = empleadosApellido2;
	}

	public Date getEmpleadosFechaN() {
		return this.empleadosFechaN;
	}

	public void setEmpleadosFechaN(Date empleadosFechaN) {
		this.empleadosFechaN = empleadosFechaN;
	}
	
	public String getEmpleadosTelefonoCasa() {
		return this.empleadosTelefonoCasa;
	}

	public void setEmpleadosTelefonoCasa(String empleadosTelefonoCasa) {
		this.empleadosTelefonoCasa = empleadosTelefonoCasa;
	}
	
	public String getEmpleadosTelefonoCel() {
		return this.empleadosTelefonoCel;
	}

	public void setEmpleadosTelefonoCel(String empleadosTelefonoCel) {
		this.empleadosTelefonoCel = empleadosTelefonoCel;
	}

	public String getEmpleadosDireccion() {
		return this.empleadosDireccion;
	}

	public void setEmpleadosDireccion(String empleadosDireccion) {
		this.empleadosDireccion = empleadosDireccion;
	}
	
	public String getEmpleadosGenero() {
		return this.empleadosGenero;
	}

	public void setEmpleadosNacionalidad(String empleadosNacionalidad) {
		this.empleadosNacionalidad = empleadosNacionalidad;
	}
	
	public void setEmpleadosGenero(String empleadosGenero) {
		this.empleadosGenero = empleadosGenero;
	}
	
	
	public String getEmpleadosNacionalidad() {
		return this.empleadosNacionalidad;
	}
	
	public String getEmpleadosCorreo() {
		return this.empleadosCorreo;
	}

	public void setEmpleadosCorreo(String empleadosCorreo) {
		this.empleadosCorreo = empleadosCorreo;
	}

	public float getEmpleadosSalario() {
		return this.empleadosSalario;
	}

	public void setEmpleadosSalario(float empleadosSalario) {
		this.empleadosSalario = empleadosSalario;
	}
	
	public String getEmpleadosPuesto() {
		return this.empleadosPuesto;
	}

	public void setEmpleadosPuesto(String empleadosPuesto) {
		this.empleadosPuesto = empleadosPuesto;
	}
	

}